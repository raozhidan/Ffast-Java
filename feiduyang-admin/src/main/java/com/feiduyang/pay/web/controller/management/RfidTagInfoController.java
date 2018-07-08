package com.feiduyang.pay.web.controller.management;

import com.feiduyang.core.annotations.Logined;
import com.feiduyang.core.annotations.Permission;
import com.feiduyang.core.support.BaseCrudController;
import com.feiduyang.pay.web.service.management.IRfidTagInfoService;
import com.feiduyang.web.entity.management.RfidTagInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description: RFID标签信息数据接口
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 21:51:08
 * @author: zhidan.rao
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/management/rfidTagInfo")
@Permission(value = "rfidTagInfo")
@Logined
public class RfidTagInfoController extends BaseCrudController<RfidTagInfo, IRfidTagInfoService, Long> {

    private static Logger logger = LoggerFactory.getLogger(RfidTagInfoController.class);

    @Resource
    private IRfidTagInfoService service;

    @Override
    protected IRfidTagInfoService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
