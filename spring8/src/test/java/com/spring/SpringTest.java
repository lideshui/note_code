package com.spring;

import com.spring.controller.EmployeeController;
import com.spring.pojo.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring测试类
 */
public class SpringTest {

    @Test
    public void test01(){
        //从类的根路径下加载配置文件，将配置文件内的bean都实例化，放到IoC容器内
        // 创建IoC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从IoC容器内取出Bean对象
        EmployeeController employeeController = ioc.getBean(EmployeeController.class);

        employeeController.addEmp();
//
//
//        Employee employeeController = ioc.getBean(Employee.class);
//
//        System.out.println(employeeController);

    }
}
