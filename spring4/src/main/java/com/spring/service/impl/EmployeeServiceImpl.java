package com.spring.service.impl;

import com.spring.pojo.Employee;
import com.spring.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * 链接点-切入点
     *
     * @param employee
     */
    @Override
    public void add(Employee employee) {
        System.out.println("执行add方法 = " + employee);
    }

    /**
     * 链接点-切入点
     * @param id
     */
    @Override
    public void delete(Integer id) {
        System.out.println("执行delete方法 = " + id);
    }

    /**
     * 链接点
     * @return
     */
    @Override
    public List<Employee> findAll() {
        System.out.println("执行search方法 = ");
        return null;
    }

    /**
     * 链接点
     * @param employee
     */
    @Override
    public void update(Employee employee) {
        System.out.println("执行update方法");
    }

}
