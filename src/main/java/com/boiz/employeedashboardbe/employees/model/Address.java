package com.boiz.employeedashboardbe.employees.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Address {

  @Id
  @GeneratedValue
  private UUID id;
  private String postalCode;
  private String street;
  private String city;
  private Double lat;
  private Double lng;

}
