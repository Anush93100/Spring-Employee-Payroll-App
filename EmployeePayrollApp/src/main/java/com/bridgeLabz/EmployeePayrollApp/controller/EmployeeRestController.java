package com.bridgeLabz.EmployeePayrollApp.controller;

/*
   Use Case : 8
   Configure Logging profiles
   created application-prod.properties and application-dev.properties
   Database is not used.
*/

import com.bridgeLabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgeLabz.EmployeePayrollApp.model.Employee;
import com.bridgeLabz.EmployeePayrollApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeePayrollService")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public List<Employee> getAllEmployeeDetails() {
        return employeeService.getAllEmployeeDetails();
    }

    @GetMapping("/get/{id}")
    public Optional<Employee> getSpecificEmployeeDetails(@PathVariable long id) {
        Employee employee = employeeService.getEmployeeDetailsByID(id);
        if (employee != null) {
            return Optional.of(employee);
        } else {
            return Optional.empty();
        }
    }

    @PostMapping("/create")
    public String creatingEmployeeRecord(@RequestBody EmployeeDTO employeeDTO){
        Employee employee=employeeService.createEmployeeRecord(employeeDTO);
        return "Created employee record\nname = " + employee.getName() + "\nsalary = " + employee.getSalary();
    }

    @PutMapping("/update/{id}")
    public String updatingEmployeeDetails(@PathVariable long id,@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeService.updateEmployeeRecord(id, employeeDTO);
        if (employee != null) {
            return "Updated employee record\nname = " + employee.getName() + "\nsalary = " + employee.getSalary();
        } else {
            return "Employee record not found";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deletingEmployeeDetails(@PathVariable long id){
        return employeeService.deleteEmployeeRecordByID(id);
    }

}
