package com.wl.cloud.config.serverce;

import com.wl.cloud.config.serverce.impl.PaymentFallbackService;
import com.wl.cloud.entities.CommonResult;
import com.wl.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author cheems
 * @Date 2023/1/10 20:52
 */

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)//调用中关闭9003服务提供者
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

}
