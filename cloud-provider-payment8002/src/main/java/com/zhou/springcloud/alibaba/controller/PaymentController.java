package com.zhou.springcloud.alibaba.controller;

import com.zhou.springcloud.alibaba.entities.Payment;
import com.zhou.springcloud.alibaba.service.PaymentService;
import com.zhou.springcloud.alibaba.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果11：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        } else {
            return new CommonResult(444, "插入数据库失败1111", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            return new CommonResult(200, "查询成功,port" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID: " + id, null);
        }
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
