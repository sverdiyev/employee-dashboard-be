package com.boiz.employeedashboardbe.employees.dto;

import lombok.Builder;

@Builder
public record AddressResponseDto(String postalCode, String street, String city, Double lat, Double lng) { }
