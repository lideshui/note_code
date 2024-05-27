package com.spring.controller;

import com.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("employeeController")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    public void addEmp(){
        employeeService.addEmployee();
    }
}
