package com.spring;

import com.spring.pojo.Employee;
import com.spring.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * spring测试类
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void test01(){
        // JdbcTemplate新增
        //employeeService.add(new Employee(null, "two dog egg", "123@.com", 1, 888d, 1));

        // JdbcTemplate删除
        //employeeService.delete(23);

        // JdbcTemplate查询
        List<Employee> employeeList = employeeService.findAll();
        System.out.println(employeeList);

        // JdbcTemplate修改
        //employeeService.update(new Employee(22, "22dog", "123@.com", 1, 888d, 1));
    }
}
