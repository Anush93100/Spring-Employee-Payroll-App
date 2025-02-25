package com.bridgeLabz.EmployeePayrollApp.model;

import lombok.Data;

@Data
public class Employee {

    private static long idCounter=1;
    private final long id;
    private String name;
    private double salary;

    public Employee() {
        id=idCounter;
        idCounter++;
    }
}
