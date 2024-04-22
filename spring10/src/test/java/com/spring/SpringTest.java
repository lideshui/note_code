package com.spring;

import com.spring.service.UserService;
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
    UserService userService;

    @Test
    public void test01() {
        userService.transfer(
                "aa",
                "bb",
                1000.0);
    }

    @Test
    public void test02() {
        userService.getById(2);
    }
}
