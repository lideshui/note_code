package com.spring.dao;


import com.spring.pojo.Department;
import com.spring.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    @Autowired
    Employee employee;

    @Autowired
    Department department;

    public void insertEmp(){
        employee.setName("注解开发测试");
        department.setName("小卖部");
        System.out.println("通过service调用dao，新增employee成功 = " + employee);
    }
}
