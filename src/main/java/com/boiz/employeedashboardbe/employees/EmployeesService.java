package com.boiz.employeedashboardbe.employees;

import com.boiz.employeedashboardbe.employees.model.Employee;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeesService {

  private final EmployeesRepository employeesRepository;

  List<Employee> getEmployees() {
    return employeesRepository.findAll();
  }

}
