package com.bridgeLabz.EmployeePayrollApp.controller;

/*
   Use Case : 4
   This is Rest Controller file to ensure that data is transmitted in REST calls.
   Note that Controller in UC4 was calling services layer to manage the Model.
   Service Layer: creating the Model and returning the Model on the REST Calls(Controller).
   Database is not used.
*/

import com.bridgeLabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgeLabz.EmployeePayrollApp.model.Employee;
import com.bridgeLabz.EmployeePayrollApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeePayrollService")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public String getAllEmployeeDetails(){
        return employeeService.getAllEmployeeDetails();
    }

    @GetMapping("/get/{id}")
    public String getSpecificEmployeeDetails(@PathVariable long id){
        return employeeService.getEmployeeDetailsByID(id);
    }

    @PostMapping("/create")
    public String creatingEmployeeRecord(@RequestBody EmployeeDTO employeeDTO){
        Employee employee=employeeService.createEmployeeRecord(employeeDTO);
        return "Created employee record\nname = " + employee.getName() + "\nsalary = " + employee.getSalary();
    }

    @PutMapping("/update")
    public String updatingEmployeeDetails(@RequestBody EmployeeDTO employeeDTO){
        Employee employee=employeeService.updateEmployeeRecord(employeeDTO);
        return "Updated employee record\nname = " +  employee.getName() + "\nsalary = " + employee.getSalary();
    }

    @DeleteMapping("/delete/{id}")
    public String deletingEmployeeDetails(@PathVariable long id){
        return employeeService.deleteEmployeeRecordByID(id);
    }

}
