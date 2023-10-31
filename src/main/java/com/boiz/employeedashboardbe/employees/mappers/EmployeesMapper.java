package com.boiz.employeedashboardbe.employees.mappers;

import com.boiz.employeedashboardbe.employees.dto.EmployeeRequestDto;
import com.boiz.employeedashboardbe.employees.dto.EmployeeResponseDto;
import com.boiz.employeedashboardbe.employees.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeesMapper {

  private final AddressMapper addressMapper;
  public Employee toEntity(EmployeeRequestDto dto){

    return Employee.builder()
      .name(dto.name())
      .address(addressMapper.toAddressEntity(dto.address()))
      .build();
  }

  public EmployeeResponseDto toResponseDto(Employee source){
    return EmployeeResponseDto.builder()
      .name(source.getName())
      .address(addressMapper.toResponseDto(source.getAddress()))
      .build();
  }

}
