package com.spring.pojo;

/**
 * 员工类
 */
public class Employee {

    private String name;

    private Department department;

    public Employee() {
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void printInfo(){
        System.out.println(this.name);
        department.printName();
    }
}
