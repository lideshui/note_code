package com.spring.service;

import com.spring.pojo.Employee;
import java.util.List;

public interface EmployeeService {

    /**
     * 新增
     * @param employee
     */
    void add(Employee employee);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 查找
     * @return
     */
    List<Employee> findAll();

    /**
     * 修改
     * @param employee
     */
    void update(Employee employee);
}
