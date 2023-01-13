package com.wl.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author cheems
 * @Date 2022/12/27 16:54
 */
@Service
public class PaymentService {
    /**
     * 正常访问，一切OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"\t"+"O(∩_∩)O";
    }

    /**
     * 超时访问
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
//          int num = 10/0;
        int timeNumber = 5000;
        try { TimeUnit.MILLISECONDS.sleep(timeNumber); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"O(∩_∩)O 支付接口正常调用";
    }

    //兜底方案fallback
    public String paymentInfo_TimeOutHandler(Integer id){
        return "我是服务提供者8001 /(ㄒoㄒ)/调用支付接口超时或异常：\t"+ "\t当前线程池名字 " + Thread.currentThread().getName();
    }

    //=========服务熔断===========
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否启用断路器
            //滚动时间窗内要达到的请求次数(断路器熔断的最小请求数，如设置了10，若在滚动时间窗内接受到了9个请求，就算都失败了，也无法触发熔断器)
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            // 该属性用来设置当断路器打开之后的休眠时间窗
            // 休眠时间窗结束之后，会将断路器置为 "半开" 状态，尝试熔断的请求命令，如果依然失败就将断路器继续设置为 "打开" 状态,如果成功就设置为 "关闭" 状态
            // 如下,若10s内(默认滚动时间窗)有10个请求，且有60%都为错误请求,
            // 断路器就会进入开启状态,进入断路器状态后8s内的所有请求都会直接走兜底方法,8s后进入半开状态若此时有请求并正常返回则会关闭熔断器,
            // 若依然是错误请求则会又开启断路器并且重新开始计时休眠时间窗
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "8000"),
            // 表示在滚动时间窗中，在请求数量超过 circuitBreaker.requestVolumeThreshold 的情况下，如果错误请求数的百分比超过60,
            // 就把断路器设置为 "打开" 状态，
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber + LocalDateTime.now();
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id +" "+ LocalDateTime.now();
    }
}