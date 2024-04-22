package com.spring.service.impl;

import com.spring.dao.UserDao;
import com.spring.pojo.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 转账
     * 注意：一定要将service中的异常抛出，确保能抛到通知中，才可以捕捉到异常进行回滚！⚠️
     */
    @Override
    public void transfer(String outName, String inName, Double money) {
        //铁甲小宝出账1000元
        userDao.outMoney(outName, money);

        //模拟异常
        System.out.println(1 / 0);

        //玛卡巴卡入账1000元
        userDao.inMoney(inName, money);
    }

    /**
     * 查询账户信息
     * 注意：一定要将service中的异常抛出，确保能抛到通知中，才可以捕捉到异常进行回滚！⚠️
     */
    public User getById(Integer id) {
        User user = userDao.getById(id);
        return user;
    }
}