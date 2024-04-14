package com.spring.utils;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * 动态代理-CGLIB代理工具类
 */
public class ProxyCGLIBUtil {


    /**
     * 根据 `被代理类对象` 获取 `代理类对象`
     *
     * @param t : 被代理类对象
     * @return : 代理类对象 (方法要和被代理类的方法相同)
     */
    static public <T> T getProxyObjectByCGLIB(final T t){

        // 创建字节码增强器
        Enhancer enhancer = new Enhancer();
        //设置目标类是代理类的父类⚠️
        enhancer.setSuperclass(t.getClass());

        // 动态生成代理类的方法
        // MethodInterceptor接口 : 拦截 `被代理类中的所有方法`
        enhancer.setCallback(new MethodInterceptor() {
            //参数说明：
            // Object proxy: 代理类对象
            // Method method: 被代理类的原始方法
            // Object[] args: 方法的实际参数
            // MethodProxy methodProxy: 代理类的方法
            @Override
            public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                String methodName = method.getName();
                if (methodName.contains("add") || methodName.contains("del")) {
                    System.out.println("权限校验");
                    // 执行目标对象的原方法(被代理类对象 调用 被代理类的原方法)⚠️
                    // Object result = method.invoke(proxy, args); //错误写法一
                    // Object result = method.invoke(clazz.newInstance(), args); //错误写法二 , 没有意义, 需要根据`字节码对象`获取`代理类对象`
                    // Object result = methodProxy.invoke(proxy, args); //错误写法三, 代理类对象 调用 代理类方法 , 不满足需求
                    result = method.invoke(t, objects);
                    System.out.println("日志记录");
                } else {
                    result = method.invoke(t, objects);
                }
                return result;
            }
        });
        // 获取代理类对象
        return (T) enhancer.create();
    }






}
