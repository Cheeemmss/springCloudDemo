package com.wl.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author cheems
 * @Date 2023/1/6 15:15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9002 {

    public static void main(String[] args) {
//        System.setProperty("nacos.server.grpc.port.offset","0");
        SpringApplication.run(PaymentMain9002.class,args);
    }
}
