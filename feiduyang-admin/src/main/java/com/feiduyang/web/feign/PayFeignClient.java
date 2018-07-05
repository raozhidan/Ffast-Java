package com.feiduyang.web.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 支付调用
 *
 * @author 45984（rao.zhidan@sccaptain.com.cn）
 * @create 2018/7/5
 */
@FeignClient(url = "127.0.0.1:8081")
@Controller
@RequestMapping("weixinMobile")
public interface PayFeignClient {

    @RequestMapping(value = "dopay", method = RequestMethod.POST)
    String dopay(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
