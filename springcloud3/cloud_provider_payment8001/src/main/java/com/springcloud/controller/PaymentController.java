package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
//@RequestBody和@RestController注解
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    //接收的Json，要使用@RequestBody注解⚠️
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if (result>0){
            //说明有数据，能查询成功
            return new CommonResult(200,"插入数据库成功",result);
        }else {
            //查询失败
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果："+payment);
        if (payment!=null){
            //说明有数据，能查询成功，打印端口号⚠️
            return new CommonResult(200,"查询成功，查询端口号为："+serverPort,payment);
        }else {
            //查询失败
            return new CommonResult(444,"没有对应记录，查询ID："+id,null);
        }
    }
}
