package com.zhou.springcloud.alibaba.service.impl;

import com.zhou.springcloud.alibaba.dao.PaymentDao;
import com.zhou.springcloud.alibaba.entities.Payment;
import com.zhou.springcloud.alibaba.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
