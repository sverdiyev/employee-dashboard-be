package com.boiz.employeedashboardbe.employees.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

  private UUID id;
  private String name;
  private String address;
  private String description;
}
