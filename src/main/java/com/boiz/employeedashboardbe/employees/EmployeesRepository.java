package com.boiz.employeedashboardbe.employees;

import com.boiz.employeedashboardbe.employees.model.Employee;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, UUID> {

}
