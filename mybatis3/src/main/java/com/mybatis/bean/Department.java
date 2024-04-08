package com.mybatis.bean;

import java.util.List;

/**
 * department部门表映射类
 */
public class Department {

    private int id;
    private String name;
    private List<Employee> empList;


    public Department() {
    }

    public Department(int id, String name, List<Employee> empList) {
        this.id = id;
        this.name = name;
        this.empList = empList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", empList=" + empList +
                '}';
    }
}
