package com.wl.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author cheems
 * @Date 2023/1/13 13:54
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SeataStorageServiceApplication2001 {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageServiceApplication2001.class, args);
    }

}
