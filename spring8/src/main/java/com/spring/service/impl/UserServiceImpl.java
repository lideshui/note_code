package com.spring.service.impl;

import com.spring.dao.UserDao;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //创建事务管理类对象
    @Autowired
    private PlatformTransactionManager transactionManager;

    //创建事务属性类对象，这里注入的definition1，因为是增删改操作
    @Autowired
    @Qualifier("definition1")
    private TransactionDefinition definition;

    /**
     * 转账
     */
    @Override
    public void transfer(String outName, String inName, Double money) {
        TransactionStatus status = null;

        try {
            //开启事务，并存储事务状态
            status = transactionManager.getTransaction(definition);
            //铁甲小宝出账1000元
            userDao.outMoney(outName, money);

            //模拟异常
            System.out.println(1 / 0);

            //玛卡巴卡入账1000元
            userDao.inMoney(inName, money);

            //没有异常就提交
            transactionManager.commit(status);

        } catch (Exception e) {
            e.printStackTrace();
            //有异常就回滚
            transactionManager.rollback(status);
        }


    }
}