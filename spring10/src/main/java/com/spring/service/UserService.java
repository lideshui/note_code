package com.spring.service;

import com.spring.pojo.User;

public interface UserService {


    /**
     * 转账
     * 注意：一定要将service中的异常抛出，确保能抛到通知中，才可以捕捉到异常进行回滚！⚠️
     */
    void transfer(String outName, String inName, Double money);

    /**
     * 查询账户信息
     * 注意：一定要将service中的异常抛出，确保能抛到通知中，才可以捕捉到异常进行回滚！⚠️
     */
    User getById(Integer id);

}
