package com.wl.cloud.service;

import com.wl.cloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author cheems
 * @Date 2023/1/13 13:49
 */
//@FeignClient(value = "seata-account-service")
//public interface AccountService {
//
//    /**
//     * 扣减账户余额
//     */
//    //@RequestMapping(value = "/account/decrease", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
//    @PostMapping("/account/decrease")
//    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
//}