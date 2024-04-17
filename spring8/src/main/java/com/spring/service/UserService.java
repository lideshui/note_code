package com.spring.service;

public interface UserService {

    /**
     * 转账
     */
    void transfer(String outName, String inName, Double money);

}
