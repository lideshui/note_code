package com.spring.utils;

import org.springframework.stereotype.Component;

/**
 * 通知类
 */
@Component
public class AspectUtil {

    /**
     * 权限验证通知类
     */
    public void checkPermission() {
        System.out.println("开始执行权限验证通知......");
    }

    /**
     * 日志记录通知类
     */
    public void printLog(){
        System.out.println("开始执行日志记录通知......");
    }


}
