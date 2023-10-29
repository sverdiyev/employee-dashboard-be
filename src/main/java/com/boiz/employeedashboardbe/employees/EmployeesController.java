package com.boiz.employeedashboardbe.employees;

import com.boiz.employeedashboardbe.employees.model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")
public class EmployeesController {

  @GetMapping
  public List<Employee> getEmployees() {
    List<Employee> employees = new ArrayList<>();

    employees.add(new Employee(UUID.randomUUID(), "name1", "address1", "description1"));
    employees.add(new Employee(UUID.randomUUID(), "name2", "address2", "description2"));
    employees.add(new Employee(UUID.randomUUID(), "name3", "address3", "description3"));

    return employees;
  }
}
