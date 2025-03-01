package com.bridgeLabz.EmployeePayrollApp.model;

import com.bridgeLabz.EmployeePayrollApp.dto.EmployeeDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Employee {

    private long employeeId;
    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;

    public Employee() { }

    public Employee(long empID, EmployeeDTO employeeDTO){
       this.employeeId=empID;
       this.name=employeeDTO.getName();
       this.salary=employeeDTO.getSalary();
       this.gender=employeeDTO.getGender();
       this.startDate=employeeDTO.getStartDate();
       this.note=employeeDTO.getNote();
       this.profilePic=employeeDTO.getProfilePic();
       this.departments=employeeDTO.getDepartments();
    }
}
