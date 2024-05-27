package com.spring.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理-JDK代理工具类
 */
public class ProxyJDKUtil {


    /**
     * 根据 `被代理类对象` 获取 `代理类对象`
     *
     * @param t : 被代理类对象
     * @return : 代理类对象 (方法要和被代理类的方法相同)
     */
    static public <T> T getProxyObjectByJDK(final T t){
        return (T) Proxy.newProxyInstance(

                //开始传入第一个参数，类加载器
                t.getClass().getClassLoader(),
                //开始传入第二个参数，目标类的接口们
                t.getClass().getInterfaces(),
                //开始传入第三个参数，InvocationHandler接口的匿名内部类对象
                new InvocationHandler() {
                    //动态生成代理类中的方法
                    //第一个参数：Object proxy。代理类对象。
                    //第二个参数：Method method。被代理类的原方法。
                    //第三个参数：Object[] args。被代理类的原方法的实际参数。
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                        Object result = null;
                        String methodName = method.getName();
                        if (methodName.contains("add") || methodName.contains("del")) {
                            //add ,delete : 增强
                            System.out.println("权限校验");
                            //执行被代理类的原方法 是不是 代理类方法执行的结果?
                            result = method.invoke(t, args);
                            System.out.println("日志记录");
                        } else {
                            //update , getById : 不增强 (只执行原方法)
                            result = method.invoke(t, args);
                        }
                        return result;
                    }
                });
    }


}
