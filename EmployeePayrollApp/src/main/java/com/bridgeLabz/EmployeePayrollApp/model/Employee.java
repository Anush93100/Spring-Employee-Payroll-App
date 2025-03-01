package com.bridgeLabz.EmployeePayrollApp.model;

import com.bridgeLabz.EmployeePayrollApp.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="employee_payroll")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private long employeeId;

    @Column(name="name")
    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name="employee_department", joinColumns = @JoinColumn(name="id"))
    @Column(name="department")
    private List<String> departments;

    public Employee() { }

    public Employee(EmployeeDTO employeeDTO){
      this.updateEmployeeData(employeeDTO);
    }

    public void updateEmployeeData(EmployeeDTO employeeDTO){
        this.name=employeeDTO.getName();
        this.salary=employeeDTO.getSalary();
        this.gender=employeeDTO.getGender();
        this.startDate=employeeDTO.getStartDate();
        this.note=employeeDTO.getNote();
        this.profilePic=employeeDTO.getProfilePic();
        this.departments=employeeDTO.getDepartments();
    }
}
