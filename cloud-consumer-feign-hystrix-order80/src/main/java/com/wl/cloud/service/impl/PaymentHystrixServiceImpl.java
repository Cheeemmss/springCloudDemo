package com.wl.cloud.service.impl;

import com.wl.cloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * @Author cheems
 * @Date 2022/12/27 20:55
 */
//若PaymentHystrixService调用远程服务失败，会走下面实现类中的对应兜底方法
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "80端口调用支付接口失败,服务提供方异常-----兜底方法";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "80端口调用支付接口失败，服务提供方异常-----兜底方法";
    }
}
