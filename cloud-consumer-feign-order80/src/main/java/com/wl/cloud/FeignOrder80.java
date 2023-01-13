package com.wl.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author cheems
 * @Date 2022/12/26 20:27
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(FeignOrder80.class,args);
    }

}
