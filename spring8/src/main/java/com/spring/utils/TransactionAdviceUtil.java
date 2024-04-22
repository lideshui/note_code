package com.spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

/**
 * 编程式事务通知类
 */
@Aspect
@Component
public class TransactionAdviceUtil {

    @Autowired
    private TransactionManagerUtil transactionManagerUtil;

    /**
     * 增删改的环绕通知 (readOnly=false)
     * 注意：一定要将service中的异常抛出，确保能抛到通知中，才可以捕捉到异常进行回滚！⚠️
     */
    @Around(value = "execution(* com.spring.service.UserService.transfer(..))")
    public Object dmlAround(ProceedingJoinPoint pjp) {
        Object result = null;
        TransactionStatus status = null;
        try {

            //开启事务
            status = transactionManagerUtil.dmlStartTransaction();

            System.out.println("执行增删改的环绕通知-前置");

            //执行切点
            result = pjp.proceed();

            System.out.println("执行增删改的环绕通知-后置");

            //没异常, 提交事务
            transactionManagerUtil.commit(status);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //有异常 , 回滚事务
            System.out.println("有异常 , 回滚事务");
            transactionManagerUtil.rollback(status);
        }
        return result;
    }


    /**
     * 查询的环绕通知 (readOnly=true)
     * 注意：一定要将service中的异常抛出，确保能抛到通知中，才可以捕捉到异常进行回滚！⚠️
     */
    @Around(value = "execution(* com.spring.service.UserService.getById(..))")
    public Object dqlAround(ProceedingJoinPoint pjp) {
        Object result = null;
        TransactionStatus status = null;
        try {

            //开启事务
            status = transactionManagerUtil.dqlStartTransaction();

            System.out.println("执行查询的环绕通知-前置");

            //执行切点
            result = pjp.proceed();

            System.out.println("执行查询的环绕通知-后置");

            //没异常, 提交事务
            transactionManagerUtil.commit(status);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //有异常 , 回滚事务
            System.out.println("有异常 , 回滚事务");
            transactionManagerUtil.rollback(status);
        }
        return result;
    }
}
