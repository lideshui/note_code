package com.springboot.test;

import com.springboot.mapper.UserMapper;
import com.springboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description: TODD
 * @AllClassName: com.atguigu.springboot.test.UserMapperTest
 */

//当导入的junit的jar包是4的时候需要该注解，指定Junit核心运行类
//@RunWith(SpringRunner.class)
//指定这是一个Spring Boot的测试类, 运行时会自动加载Spring Boot运行环境
@SpringBootTest

public class UserMapperTest {
    //会有红色虚线，因为没检测到该对象，不过运行时会创建代理对象
    //可以在Mapper上加@repository注解取消报红，但是没必要
    @Autowired
    private UserMapper userMapper;


    /**
     * 创建查询所有测试类，导入的@Test注解是Juint5的注解，千万别导错了
     * 注意导入的@Test注解包名为：import org.junit.jupiter.api.Test;⚠️️
     */
    @Test
    public void testSelectAll(){
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    /**
     * 测试添加
     */
    @Test
    public void testInsert(){
        User user = new User(null,"小黑","男",18,"宏福苑","512354665","5123@emal.com","xiaobai","13062065627");
        //插入数据
        userMapper.insert(user);
    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdate(){
        //根据主键id获取一个user
        User user = userMapper.selectByPrimaryKey(11);
        //修改属性
        user.setName("小白");
        //提交修改
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete(){
        //删除并接收影响的行数，也可以不接收，这里是物理删除
        int line = userMapper.deleteByPrimaryKey(11);
        System.out.println("line = " + line);
    }
}
