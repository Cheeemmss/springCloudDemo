package com.wl.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cheems
 * @Date 2023/1/9 14:14
 */
@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "----testC";
    }

    @GetMapping("/testD")
    public String testD(){
        int a = 1/0;
        return "----testD";
    }

    @GetMapping("/testE")
    public String testE(){
        return "----testE";
    }

    @GetMapping("/testF")
    @SentinelResource(value = "testF",blockHandler = "hotKeyHandler")
    public String testF(@RequestParam(value = "a",required = false)String a,
                        @RequestParam(value = "b",required = false)String b){
        log.info("a={},b={}",a,b);
        return "---testF";
    }

    public String hotKeyHandler(String a, String b, BlockException blockException){
        return "---im hotkey handler";
    }
}

