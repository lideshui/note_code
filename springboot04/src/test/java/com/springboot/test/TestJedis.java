package com.springboot.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;


//指定这是一个Spring Boot的测试类, 运行时会自动加载Spring Boot运行环境
@SpringBootTest
public class TestJedis {

    @Autowired
    Jedis jedis;
    @Test
    public void test(){
        // 打印自动注入的Jedis对象
        System.out.println("Stored string in redis:: " + jedis);

        // 示例：向redis设置一个键值对
        jedis.set("foo", "bar");

        // 示例：从redis获取一个键的值
        String value = jedis.get("foo");
        System.out.println("Stored string in redis:: " + value);
        jedis.close();
    }
}

