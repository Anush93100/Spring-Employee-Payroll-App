package com.bridgeLabz.EmployeePayrollApp.controller;

/*
   Use Case : 2
   This is Rest Controller file to ensure that data is transmitted in REST calls
 */

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeePayrollService")
public class EmployeeRestController {

    @GetMapping("")
    public String getAllEmployeeDetails(){
        return "GET: getting all employee record";
    }

    @GetMapping("/get/{id}")
    public String getSpecificEmployeeDetails(@PathVariable long id){
        return "GET: getting employee record with id " + id ;
    }

    @PostMapping("/create")
    public String creatingEmployeeRecord(@RequestParam(value = "name") String name,
                                         @RequestParam(value = "salary") long salary){
        return "POST: created employee record\nname = " + name + "\nsalary = " + salary;
    }

    @PutMapping("/update")
    public String updatingEmployeeDetails(@RequestParam(value = "name") String name,
                                          @RequestParam(value = "salary") long salary){
        return "PUT: updated employee record\nname = " + name + "\nsalary = " + salary;
    }

    @DeleteMapping("/delete/{id}")
    public String deletingEmployeeDetails(@PathVariable long id){
        return "DELETE: deleted employee record with id " + id ;
    }
    
}
