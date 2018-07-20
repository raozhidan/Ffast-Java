package com.feiduyang.web.controller.management;

import com.feiduyang.api.management.IOwnerProductInfoService;
import com.feiduyang.common.annotations.Logined;
import com.feiduyang.common.annotations.Permission;
import com.feiduyang.common.entity.management.OwnerProductInfo;
import com.feiduyang.common.support.BaseCrudController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description: 车主购买的套餐产品信息数据接口
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 21:51:08
 * @author: zhidan.rao
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/management/ownerProductInfo")
@Permission(value = "ownerProductInfo")
@Logined
public class OwnerProductInfoController extends BaseCrudController<OwnerProductInfo, IOwnerProductInfoService, Long> {

    private static Logger logger = LoggerFactory.getLogger(OwnerProductInfoController.class);

    @Resource
    private IOwnerProductInfoService service;

    @Override
    protected IOwnerProductInfoService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
