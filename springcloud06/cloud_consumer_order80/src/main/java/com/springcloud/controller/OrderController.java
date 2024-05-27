package com.springcloud.controller;


import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //配置远程调用的微服务的地址，要写服务的名字CLOUD_PAYMENT_SERVICE
    //名字必须从Eureka注册中心进行http://localhost:7001/查看⚠️
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    //注入远程调用对象
    @Resource
    private RestTemplate restTemplate;


    //==> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        String result = restTemplate.getForObject(PAYMENT_URL    +"/payment/zipkin/", String.class);
        return result;
    }


}
