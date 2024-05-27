package com.springcloud.service.impl;

import com.springcloud.dao.PaymentDao;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class PaymentServiceImpl implements PaymentService {

    //使用@Resource注解代替@Autowired注解，可防止报红
    @Resource
    //@Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById( Long id){
        return paymentDao.getPaymentById(id);
    }
}