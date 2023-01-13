package com.wl.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wl.cloud.entities.CommonResult;

/**
 * @Author cheems
 * @Date 2023/1/10 19:10
 */

public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息......CustomerBlockHandler");
    }

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息......CustomerBlockHandler2");
    }

}
