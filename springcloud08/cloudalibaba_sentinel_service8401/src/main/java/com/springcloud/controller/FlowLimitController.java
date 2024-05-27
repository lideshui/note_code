package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.handler.CustomerBlockHandler;
import com.springcloud.handler.CustomerFallBack;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController{
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }

//    // 从13.2开始出现异常调用的兜底方法，后续该代码中的降级兜底和异常兜底方法都封装到兜底类中了
//    public String deal_testHotKey_exception (String p1, String p2, Throwable exception){
//        return "方法执行出现了异常";
//    }
//
//
//    @GetMapping("/testHotKey")
//    /**
//     * 违反规则时：
//     * 关于@SentinelResource注解
//     * value属性：指定流量限制的资源名
//     * blockHandler属性：指定违反规则时调用的兜底方法名
//     * blockHandlerClass属性：指定包含违法规则时调用的降级方法的类的类型
//     * 出现异常时：
//     * fallback属性：指定出异常时调用的兜底方法名
//     * fallbackClass属性：指定出异常时调用的兜底方法的类的类型
//     * 要注意降级方法的返回值和参数要一致⚠️
//     */
//    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey", fallback = "deal_testHotKey_exception")
//    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
//                             @RequestParam(value = "p2",required = false) String p2) {
////        int age = 10/0;
//        return "------testHotKey";
//    }
//
//
//    //兜底方法
//    public String deal_testHotKey (String p1, String p2, BlockException exception){
//        return "------deal_testHotKey,o(╥﹏╥)o";
//    }

    /**
     * 违反规则时：
     * 关于@SentinelResource注解
     * value属性：指定流量限制的资源名
     * blockHandler属性：指定违反规则时调用的兜底方法名
     * blockHandlerClass属性：指定包含违法规则时调用的降级方法的类的类型
     * 出现异常时：
     * fallback属性：指定出异常时调用的兜底方法名
     * fallbackClass属性：指定出异常时调用的兜底方法的类的类型
     * 要注意降级方法的返回值和参数要一致⚠️
     */
    @GetMapping("/testHotKey")
    @SentinelResource(
            value = "testHotKey",
            blockHandler = "handleException2",
            blockHandlerClass = CustomerBlockHandler.class,
            fallback = "fallBack1",
            fallbackClass = CustomerFallBack.class
    )
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
        //模拟异常⚠️
        //int age = 10/0;
        return "------testHotKey";
    }

}