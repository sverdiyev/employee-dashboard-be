package com.boiz.employeedashboardbe.employees;

import com.boiz.employeedashboardbe.employees.model.Employee;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")
@RequiredArgsConstructor
public class EmployeesController {

  private final EmployeesService employeesService;

  @GetMapping
  public List<Employee> getEmployees() {
    return employeesService.getEmployees();
  }
}
