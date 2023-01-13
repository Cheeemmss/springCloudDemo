package com.wl.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author cheems
 * @Date 2023/1/6 15:15
 */
@SpringBootApplication
@EnableDiscoveryClient //开启服务注册/发现功能
public class PaymentMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9001.class,args);
    }
}
