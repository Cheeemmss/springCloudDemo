package com.wl.cloud.config.serverce.impl;

import com.wl.cloud.config.serverce.PaymentService;
import com.wl.cloud.entities.CommonResult;
import com.wl.cloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author cheems
 * @Date 2023/1/10 20:53
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));
    }
}
