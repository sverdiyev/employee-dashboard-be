package com.boiz.employeedashboardbe.employees;

import com.boiz.employeedashboardbe.employees.dto.EmployeeRequestDto;
import com.boiz.employeedashboardbe.employees.dto.EmployeeResponseDto;
import com.boiz.employeedashboardbe.employees.mappers.EmployeesMapper;
import com.boiz.employeedashboardbe.employees.model.Address;
import com.boiz.employeedashboardbe.employees.model.Employee;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeesService {

  private final EmployeesRepository employeesRepository;
  private final EmployeesMapper employeesMapper;

  //TODO provide env variable GMAPS_KEY
  @Value("${GMAPS_KEY}")
  private String GOOGLE_MAPS_KEY;
  private final GeoApiContext ctx = new GeoApiContext.Builder().apiKey(GOOGLE_MAPS_KEY).build();

  List<Employee> getEmployees() {
    return employeesRepository.findAll();
  }

  private void populateLatLongForSingleAddress(@NotNull Address address){

    try {
      GeocodingResult geocodingResults =
        GeocodingApi.geocode(ctx, address.getCity() + ", " + address.getStreet() + ", " + address.getPostalCode())
          .await()[0];

      var lat = geocodingResults.geometry.location.lat;
      var lng = geocodingResults.geometry.location.lng;

      address.setLat(lat);
      address.setLng(lng);
    } catch (ApiException | IOException | InterruptedException e) {
      System.out.println("some error happened");
      throw new RuntimeException(e);
    }

  }

  public EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDTO) {

    System.out.println(GOOGLE_MAPS_KEY);
    Employee newEmployee = employeesMapper.toEntity(employeeRequestDTO);
    populateLatLongForSingleAddress(newEmployee.getAddress());

    return employeesMapper.toResponseDto( employeesRepository.save(newEmployee));

  }
}
