package com.bridgeLabz.EmployeePayrollApp.repository;

import com.bridgeLabz.EmployeePayrollApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
