package com.boiz.employeedashboardbe.employees;

import com.boiz.employeedashboardbe.employees.model.Address;
import com.boiz.employeedashboardbe.employees.model.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
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

    var adr1 = Address.builder()
      .city("warsaw").street("Kasprzaka").postalCode("01-234").build();
    var adr2 = Address.builder()
      .city("lviv").street("pasichna").postalCode("79032").build();

    var empl1 = Employee.builder().address(adr1).name("sasha POL").build();
    var empl2 = Employee.builder().address(adr2).name("sasha UKR").build();

    employeesRepository.saveAll(List.of(empl1, empl2));
  }
}
