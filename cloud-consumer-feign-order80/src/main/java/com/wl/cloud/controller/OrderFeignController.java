package com.wl.cloud.controller;

import com.wl.cloud.entities.CommonResult;
import com.wl.cloud.entities.Payment;
import com.wl.cloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author cheems
 * @Date 2022/12/26 20:29
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService  paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
       return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        return paymentFeignService.paymentFeignTimeOut();
    }
}

