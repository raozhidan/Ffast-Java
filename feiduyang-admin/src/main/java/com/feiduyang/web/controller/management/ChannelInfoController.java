package com.feiduyang.web.controller.management;

import com.feiduyang.api.management.IChannelInfoService;
import com.feiduyang.common.annotations.Logined;
import com.feiduyang.common.annotations.Permission;
import com.feiduyang.common.entity.management.ChannelInfo;
import com.feiduyang.common.support.BaseCrudController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description: 渠道信息数据接口
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 21:51:08
 * @author: zhidan.rao
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/management/channelInfo")
@Permission(value = "channelInfo")
@Logined
public class ChannelInfoController extends BaseCrudController<ChannelInfo, IChannelInfoService, Long> {

    private static Logger logger = LoggerFactory.getLogger(ChannelInfoController.class);

    @Resource
    private IChannelInfoService service;

    @Override
    protected IChannelInfoService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
