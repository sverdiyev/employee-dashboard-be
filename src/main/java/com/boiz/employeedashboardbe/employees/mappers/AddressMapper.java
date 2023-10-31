package com.boiz.employeedashboardbe.employees.mappers;

import com.boiz.employeedashboardbe.employees.dto.AddressRequestDto;
import com.boiz.employeedashboardbe.employees.dto.AddressResponseDto;
import com.boiz.employeedashboardbe.employees.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
  public Address toAddressEntity(AddressRequestDto source){
    return Address.builder()
      .city(source.city())
      .street(source.street())
      .postalCode(source.postalCode())
      .build();
  }

  public AddressResponseDto toResponseDto(Address source){
    return AddressResponseDto.builder()
      .postalCode(source.getPostalCode())
      .city(source.getCity())
      .lat(source.getLat())
      .lng(source.getLng())
      .street(source.getStreet())
      .build();
  }

}
