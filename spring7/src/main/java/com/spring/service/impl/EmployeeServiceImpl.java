package com.spring.service.impl;

import com.spring.dao.EmployeeDao;
import com.spring.pojo.Employee;
import com.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    /**
     * 新增
     * @param employee
     */
    @Override
    public void add(Employee employee) {
        employeeDao.insert(employee);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id) {
        employeeDao.delete(id);
    }

    /**
     * 查询
     * @return
     */
    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = employeeDao.select();
        return employeeList;
    }

    /**
     * 更新
     * @param employee
     */
    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

}
