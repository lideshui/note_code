package com.springcloud.service;

import com.springcloud.entities.Payment;


public interface PaymentService {
    /**
     * 写入数据
     */
    int create(Payment payment);

    /**
     * 读取数据
     */
    public Payment getPaymentById(Long id);

}