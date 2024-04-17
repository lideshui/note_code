package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    // 将Spring容器中的JdbcTemplate对象注入使用
    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 取款
     */
    public void outMoney(String outName, Double money) {
        int count = jdbcTemplate.update("update account set balance = balance - ? where username = ?", money, outName);
        System.out.println(outName + " 出账 " + money + "元, count = " + count);
    }

    /**
     * 存款
     */
    public void inMoney(String inName, Double money) {
        int count = jdbcTemplate.update("update account set balance = balance + ? where username = ?", money, inName);
        System.out.println(inName + " 入账 " + money + "元, count = " + count);
    }
}