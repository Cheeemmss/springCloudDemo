package com.wl.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author cheems
 * @Date 2023/1/6 16:04
 */
@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    private final String serverURL = "http://nacos-payment-provider";

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
    }

}
