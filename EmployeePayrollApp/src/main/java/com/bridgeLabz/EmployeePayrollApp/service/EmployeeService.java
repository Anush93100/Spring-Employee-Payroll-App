package com.bridgeLabz.EmployeePayrollApp.service;

import com.bridgeLabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgeLabz.EmployeePayrollApp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employees;

    EmployeeService(){
        employees=new ArrayList<>();
    }

    public List<Employee> getAllEmployeeDetails(){
         return employees;
    }

    public Employee getEmployeeDetailsByID(long id) {
        for(Employee e:employees){
            if(e.getId()==id){
                return e;
            }
        }
        return null;
    }

    public Employee createEmployeeRecord(EmployeeDTO employeeDTO){
        Employee employee=new Employee();

        String name=employeeDTO.getName();
        double salary=employeeDTO.getSalary();

        employee.setName(name);
        employee.setSalary(salary);

        employees.add(employee);
        return employee;
    }

    public Employee updateEmployeeRecord(long id,EmployeeDTO employeeDTO) {
            Employee employee = getEmployeeDetailsByID(id);
            if(employee==null){
                return null;
            }
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
        if (employee == null) {
            return "Employee record not found";
        }
        else{
            for(int i=0;i<employees.size();i++){
                if(employees.get(i)==employee){
                    employees.remove(i);
                    return "Deleted Employee record with id " + id;
                }
            }
        }
        return "Employee record not found";
    }

}
