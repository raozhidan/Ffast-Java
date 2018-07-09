package com.feiduyang.web.controller.management;

import com.feiduyang.common.annotations.Logined;
import com.feiduyang.common.annotations.Permission;
import com.feiduyang.core.support.BaseCrudController;
import com.feiduyang.web.entity.management.PointInfo;
import com.feiduyang.web.service.management.IPointInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description: 商户的点位信息数据接口
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 21:51:08
 * @author: zhidan.rao
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/management/pointInfo")
@Permission(value = "pointInfo")
@Logined
public class PointInfoController extends BaseCrudController<PointInfo, IPointInfoService, Long> {

    private static Logger logger = LoggerFactory.getLogger(PointInfoController.class);

    @Resource
    private IPointInfoService service;

    @Override
    protected IPointInfoService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
