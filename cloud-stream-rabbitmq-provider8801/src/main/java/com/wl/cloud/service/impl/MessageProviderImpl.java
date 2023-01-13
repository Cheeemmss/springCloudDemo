package com.wl.cloud.service.impl;

import com.wl.cloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author cheems
 * @Date 2023/1/5 15:01
 */
@EnableBinding(Source.class) // 可以理解为是一个消息的发送管道的定义 里面包含了@configration可以被扫描到
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息的发送管道

    @Override
    public String send() {
        String serialMessage = UUID.randomUUID().toString();
        this.output.send(MessageBuilder.withPayload(serialMessage).build()); // 创建并发送消息
        System.out.println("***serial: "+serialMessage);
        return serialMessage;
    }
}