package com.feiduyang.web.controller.management;

import com.feiduyang.api.management.INonMotorizedVehicleInfoService;
import com.feiduyang.common.annotations.Logined;
import com.feiduyang.common.annotations.Permission;
import com.feiduyang.common.entity.management.NonMotorizedVehicleInfo;
import com.feiduyang.common.support.BaseCrudController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description: 非机动车信息数据接口
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 21:51:08
 * @author: zhidan.rao
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/management/nonMotorizedVehicleInfo")
@Permission(value = "nonMotorizedVehicleInfo")
@Logined
public class NonMotorizedVehicleInfoController extends BaseCrudController<NonMotorizedVehicleInfo, INonMotorizedVehicleInfoService, Long> {

    private static Logger logger = LoggerFactory.getLogger(NonMotorizedVehicleInfoController.class);

    @Resource
    private INonMotorizedVehicleInfoService service;

    @Override
    protected INonMotorizedVehicleInfoService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
