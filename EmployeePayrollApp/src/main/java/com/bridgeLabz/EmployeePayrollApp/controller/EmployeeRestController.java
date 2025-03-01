package com.bridgeLabz.EmployeePayrollApp.controller;

/*
   Use Case : 17
   Ability to retrieve all the records of employee payroll pertaining to sales department
   - Note: Use Custom Query using annotation @Query to retrieve employee of sales department
*/

import com.bridgeLabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgeLabz.EmployeePayrollApp.model.Employee;
import com.bridgeLabz.EmployeePayrollApp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeePayrollService")
@Slf4j
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public List<Employee> getAllEmployeeDetails() {
        return employeeService.getAllEmployeeDetails();
    }

    @GetMapping("/get/{id}")
    public Employee getSpecificEmployeeDetails(@PathVariable long id) {
        return employeeService.getEmployeeDetailsByID(id);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable("department") String department) {
        return employeeService.getEmployeeByDepartment(department);
    }

    @PostMapping("/create")
    public Employee creatingEmployeeRecord(@Valid @RequestBody EmployeeDTO employeeDTO){
        return employeeService.createEmployeeRecord(employeeDTO);
    }

    @PutMapping("/update/{id}")
    public Employee updatingEmployeeDetails(@PathVariable long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployeeRecord(id, employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deletingEmployeeDetails(@PathVariable long id){
        return employeeService.deleteEmployeeRecordByID(id);
    }

}
