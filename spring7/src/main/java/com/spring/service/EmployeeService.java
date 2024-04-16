package com.spring.service;

import com.spring.pojo.Employee;
import java.util.List;

public interface EmployeeService {

    /**
     * 链接点-切入点
     * @param employee
     */
    void add(Employee employee);

    /**
     * 链接点-切入点
     * @param id
     */
    void delete(Integer id);

    /**
     * 链接点
     * @return
     */
    List<Employee> findAll();

    /**
     * 链接点
     * @param employee
     */
    void update(Employee employee);
}
