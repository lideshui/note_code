package com.lds.bean;


public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Double salary;
    private Integer deptId;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Double salary, Integer deptId) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
        this.deptId = deptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                ", deptId=" + deptId +
                '}';
    }
}
