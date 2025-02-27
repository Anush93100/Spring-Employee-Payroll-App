package com.bridgeLabz.EmployeePayrollApp.controller;

/*
   Use Case : 11
   Provide User Friendly Error Response in case validation fails.
   - Created Custom GlobalExceptionHandler class using @RestControllerAdvice Annotation so that Spring
     Framework can call this class to handle Exceptions thrown during processing REST API Request.
   - Added @ExceptionHandler for MethodArgumentNotValidException.
*/

import com.bridgeLabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgeLabz.EmployeePayrollApp.model.Employee;
import com.bridgeLabz.EmployeePayrollApp.service.EmployeeService;
import jakarta.validation.Valid;
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
    public String creatingEmployeeRecord(@Valid @RequestBody EmployeeDTO employeeDTO){
        Employee employee=employeeService.createEmployeeRecord(employeeDTO);
        return "Created employee record\nname = " + employee.getName() + "\nsalary = " + employee.getSalary();
    }

    @PutMapping("/update/{id}")
    public String updatingEmployeeDetails(@PathVariable long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
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
