package com.spring;

import com.spring.dao.EmployeeDao;
import com.spring.pojo.Employee;
import com.spring.service.UserService;
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
    EmployeeDao employeeDao;

    @Test
    public void test01() {
        List<Employee> list = employeeDao.findAll();
        System.out.println(list);
    }

    @Test
    public void test02() {
        Employee employee = employeeDao.getById(2);
        System.out.println(employee);
    }
}
