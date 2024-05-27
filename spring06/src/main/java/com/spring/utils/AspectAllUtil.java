package com.spring.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 * AOP注解开发通知类
 */
@Aspect
@Component
@Order(1) //@Order注解标识切面类控制顺序。@Order注解的value指定一个整数型的数字，数字越小，优先级越高。
public class AspectAllUtil {

    /**
     * 通过@Pointcut注解，抽取切点表达式到pointcut()方法上
     */
    @Pointcut("execution(* com.spring.service.EmployeeService.add(..))")
    public void pointcut() {
    }

    /**
     * 前置通知
     */
    @Before("pointcut()")
    public void before(JoinPoint jp) {
        //获取切入点输入参数
        Object[] args = jp.getArgs();
        System.out.println("AspectAllUtil before 前置通知参数 : " + Arrays.toString(args));
    }


    /**
     * 正常后置通知 : 在切入点之后执行, 当切入点没有异常才执行
     */
    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("AspectAllUtil afterReturning 正常后置通知返回值 : " + result);
    }


    /**
     * 异常后置通知 : 在切入点之后执行, 当切入点有异常才执行
     */
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("AspectAllUtil afterThrowing 异常后置通知");

    }


    /**
     * 后置通知 : 在切入点之后执行, 不管切入点是否有异常都执行
     */
    @After("pointcut()")
    public void after() {
        System.out.println("AspectAllUtil after 后置通知");
    }


    /**
     * 环绕通知 : 在切入点之前执行, 在切入点之后执行
     * @param pjp : 切入点对象
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) {
        try {
            //获取切入点输入参数
            Object[] args = pjp.getArgs();

            System.out.println("AspectAllUtil around 环绕通知之前 " + Arrays.toString(args));

            //执行被代理类的原方法(切入点) , 需要将切入点执行之后的结果返回
            Object result = pjp.proceed();//切入点

            System.out.println("AspectAllUtil around 环绕通知之后 " + Arrays.toString(args) + "获取返回值"  + result);

            return result; // 把结果返回给切入点方法

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //切入点有异常，继续将异常抛出，如果不抛出，异常后置通知便无法捕获到了
            throw new RuntimeException(throwable);
        }
    }



}
