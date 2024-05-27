package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//指定要扫描Mapper接口的包名，创建代理对象，该注解一定是加强版的TKMapper注解⚠️
@MapperScan(basePackages = "com.springboot.mapper")
//开启事务支持
@EnableTransactionManagement
public class SpringbootCaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootCaseApplication.class, args);
    }
}