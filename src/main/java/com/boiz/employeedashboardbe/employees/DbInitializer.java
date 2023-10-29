package com.boiz.employeedashboardbe.employees;

import com.boiz.employeedashboardbe.employees.model.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DbInitializer {

  private final EmployeesRepository employeesRepository;

  @PostConstruct
  @Transactional
  public void initializeDb() {
    List<Employee> employees = new ArrayList<>();

    employees.add(new Employee("name1", "address1", "description1"));
    employees.add(new Employee("name2", "address2", "description2"));
    employees.add(new Employee("name3", "address3", "description3"));

    employeesRepository.saveAll(employees);
  }
}
