package com.feiduyang.web.controller.management;

import com.feiduyang.core.annotations.Logined;
import com.feiduyang.core.annotations.Permission;
import com.feiduyang.core.support.BaseCrudController;
import com.feiduyang.web.entity.management.PayFlow;
import com.feiduyang.web.service.management.IPayFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description: 支付流水信息数据接口
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 21:51:08
 * @author: zhidan.rao
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/management/payFlow")
@Permission(value = "payFlow")
@Logined
public class PayFlowController extends BaseCrudController<PayFlow, IPayFlowService, Long> {

    private static Logger logger = LoggerFactory.getLogger(PayFlowController.class);

    @Resource
    private IPayFlowService service;

    @Override
    protected IPayFlowService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
