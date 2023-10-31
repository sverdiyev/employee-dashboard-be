package com.boiz.employeedashboardbe.employees.dto;

import lombok.Builder;

@Builder
public record EmployeeResponseDto(String name, AddressResponseDto address) {

}
