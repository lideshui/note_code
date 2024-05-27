package com.spring;

import com.spring.pojo.Employee;
import com.spring.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        employeeService.add(new Employee("二狗子"));
        employeeService.update(new Employee("大狗子"));
    }
}
