package com.feiduyang.web.controller.management;

import com.feiduyang.common.annotations.Logined;
import com.feiduyang.common.annotations.Permission;
import com.feiduyang.core.support.BaseCrudController;
import com.feiduyang.web.entity.management.VehicleOwnerInfo;
import com.feiduyang.web.service.management.IVehicleOwnerInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description: 车主信息数据接口
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 21:51:08
 * @author: zhidan.rao
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/management/vehicleOwnerInfo")
@Permission(value = "vehicleOwnerInfo")
@Logined
public class VehicleOwnerInfoController extends BaseCrudController<VehicleOwnerInfo, IVehicleOwnerInfoService, Long> {

    private static Logger logger = LoggerFactory.getLogger(VehicleOwnerInfoController.class);

    @Resource
    private IVehicleOwnerInfoService service;

    @Override
    protected IVehicleOwnerInfoService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
