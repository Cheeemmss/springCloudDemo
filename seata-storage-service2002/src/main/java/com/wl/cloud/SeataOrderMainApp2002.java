package com.wl.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author cheems
 * @Date 2023/1/13 14:15
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SeataOrderMainApp2002 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp2002.class, args);
    }
}
