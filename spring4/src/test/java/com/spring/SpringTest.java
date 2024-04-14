package com.spring;

import com.spring.pojo.Employee;
import com.spring.service.EmployeeService;
import com.spring.utils.ProxyCGLIBUtil;
import com.spring.utils.ProxyJDKUtil;
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
        EmployeeService employeeServiceProxy1 = ProxyJDKUtil.getProxyObjectByJDK(employeeService);
        employeeServiceProxy1.add(new Employee("jdk代理"));
        employeeServiceProxy1.update(new Employee("jdk代理"));

        EmployeeService employeeServiceProxy2 = ProxyCGLIBUtil.getProxyObjectByCGLIB(employeeService);
        employeeServiceProxy2.add(new Employee("CGLIB代理"));
        employeeServiceProxy2.update(new Employee("CGLIB代理"));
    }
}
