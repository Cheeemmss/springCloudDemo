package com.wl.cloud.service;

/**
 * @Author cheems
 * @Date 2023/1/13 14:07
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
