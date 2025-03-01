package com.bridgeLabz.EmployeePayrollApp.service;

import com.bridgeLabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgeLabz.EmployeePayrollApp.exception.EmployeeNotFoundException;
import com.bridgeLabz.EmployeePayrollApp.model.Employee;
import com.bridgeLabz.EmployeePayrollApp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    List<Employee> employees;

    EmployeeService(){
        employees=new ArrayList<>();
    }

    public List<Employee> getAllEmployeeDetails(){
         return employees;
    }

    public Employee getEmployeeDetailsByID(long id) {
        return employees.stream()
                .filter(e -> e.getEmployeeId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee createEmployeeRecord(EmployeeDTO employeeDTO){
        Employee employee=new Employee(employeeDTO);
        employees.add(employee);
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployeeRecord(long id,EmployeeDTO employeeDTO) {
            Employee employee = getEmployeeDetailsByID(id);

            String name = employeeDTO.getName();
            double salary = employeeDTO.getSalary();

            if (!name.isEmpty()) {
                employee.setName(name);
            }
            if (salary > 0) {
                employee.setSalary(salary);
            }
            return employee;
    }

    public String deleteEmployeeRecordByID(long id) {
        Employee employee = getEmployeeDetailsByID(id);

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) == employee) {
                employees.remove(i);
                return "Deleted Employee record with id " + id;
            }
        }

        return "Employee record not found";
    }

}
