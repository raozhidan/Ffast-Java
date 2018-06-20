package com.feiduyang.web.controller.management;

import com.feiduyang.core.annotations.Logined;
import com.feiduyang.core.annotations.Permission;
import com.feiduyang.core.support.BaseCrudController;
import com.feiduyang.web.entity.management.VehicleCheckInOutFlow;
import com.feiduyang.web.service.management.IVehicleCheckInOutFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description: 车辆进出流水信息数据接口
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 21:51:08
 * @author: zhidan.rao
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/management/vehicleCheckInOutFlow")
@Permission(value = "vehicleCheckInOutFlow")
@Logined
public class VehicleCheckInOutFlowController extends BaseCrudController<VehicleCheckInOutFlow, IVehicleCheckInOutFlowService, Long> {

    private static Logger logger = LoggerFactory.getLogger(VehicleCheckInOutFlowController.class);

    @Resource
    private IVehicleCheckInOutFlowService service;

    @Override
    protected IVehicleCheckInOutFlowService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
