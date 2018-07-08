package com.feiduyang.pay.web.feign;

import com.feiduyang.core.vo.ResponseInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 支付调用
 *
 * @author 45984（rao.zhidan@sccaptain.com.cn）
 * @create 2018/7/5
 */
@FeignClient(url = "127.0.0.1:8081", name = "api")
@RequestMapping("/feiduyangPay")
public interface PayFeignClient {

    @RequestMapping(value = "dopay", method = RequestMethod.POST)
    ResponseInfo dopay(@RequestParam("outTradeNo") String outTradeNo, @RequestParam("totalFee") String totalFee,
                       @RequestParam("code") String code) throws Exception;
}