package com.spring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

/**
 * 事务管理的工具类
 * 开启事务
 * 提交事务
 * 回滚事务
 */
@Component
public class TransactionManagerUtil {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    @Qualifier("definition1")
    private TransactionDefinition definition;

    @Autowired
    @Qualifier("definition2")
    private TransactionDefinition definition2;

    /**
     * 增删改方法的开启事务
     *
     * @return
     */
    public TransactionStatus dmlStartTransaction() {
        TransactionStatus status = transactionManager.getTransaction(definition);
        return status;
    }


    /**
     * 查询方法的开启事务
     *
     * @return
     */
    public TransactionStatus dqlStartTransaction() {
        TransactionStatus status = transactionManager.getTransaction(definition2);
        return status;
    }


    /**
     * 提交事务
     *
     * @param status
     */
    public void commit(TransactionStatus status) {
        transactionManager.commit(status);
    }


    /**
     * 回滚事务
     *
     * @param status
     */
    public void rollback(TransactionStatus status) {
        transactionManager.rollback(status);
    }
}
