package com.spring.dao;


import com.spring.pojo.Employee;

public class EmployeeDao {

    Employee employee;

    public EmployeeDao() {
        System.out.println("EmployeeDao构造方法执行111");
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        System.out.println("EmployeeDao的setEmployee方法执行111");
    }

    public void insertEmp(){
        System.out.println("通过service调用dao，新增employee成功 = " + employee);
    }
}
