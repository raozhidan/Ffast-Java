package com.feiduyang.web.controller.management;

import com.feiduyang.core.support.BaseCrudController;
import com.feiduyang.web.entity.management.BusinessInfo;
import com.feiduyang.web.service.management.IBusinessInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description: 商户信息数据接口
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 21:51:08
 * @author: zhidan.rao
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/management/businessInfo")
public class BusinessInfoController extends BaseCrudController<BusinessInfo, IBusinessInfoService, Long> {

    private static Logger logger = LoggerFactory.getLogger(BusinessInfoController.class);

    @Resource
    private IBusinessInfoService service;

    @Override
    protected IBusinessInfoService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
