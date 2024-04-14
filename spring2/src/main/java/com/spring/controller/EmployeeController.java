package com.spring.controller;

import com.spring.service.EmployeeService;

public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController() {
        System.out.println("EmployeeController构造方法执行333");
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
        System.out.println("EmployeeController的setEmployeeService方法执行333");
    }

    public void addEmp(){
        employeeService.addEmployee();
    }
}
