package com.bridgeLabz.EmployeePayrollApp.controller;

/*
   Use Case : 14
   Ensure validations is done on the Payroll DTO
   - Here we need to add validators to gender, startDate, note, profilePic and department
   - Majority like note, profilePic, etc. are just No Blank
   - The Validation needs to be done for both Create and Update REST Calls

   - Note: Used @JsonFormat(pattern="dd MMM yyyy") to convert startDate to Local Date as well as the Validation
     for Past and Present
   - Note: have added @Slf4j log to both Controller and Services
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
