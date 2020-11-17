package com.zhou.springcloud.alibaba.service;

import com.zhou.springcloud.alibaba.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
