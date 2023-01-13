package com.wl.cloud.service;

import com.wl.cloud.domain.Order;

/**
 * @Author cheems
 * @Date 2023/1/13 13:46
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
