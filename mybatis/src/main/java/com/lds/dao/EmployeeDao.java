package com.lds.dao;



import com.lds.bean.Employee;

import java.util.List;

/**
 * 对数据库中employees这个表的所有操作
 */
public interface EmployeeDao {

    List<Employee> findAll();

    Employee getById(Integer id);

    void insert(Employee employee);

    void update(Employee employee);

    void delete(Integer id);
}