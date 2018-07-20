package com.feiduyang.web.controller.management;

import com.feiduyang.api.management.IVehicleCheckInOutFlowService;
import com.feiduyang.common.annotations.Logined;
import com.feiduyang.common.annotations.Permission;
import com.feiduyang.common.entity.management.VehicleCheckInOutFlow;
import com.feiduyang.common.support.BaseCrudController;
import com.feiduyang.common.vo.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 车辆进出流水信息数据接口
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 21:51:08
 * @author: zhidan.rao
 * @version: 1.0
 */
@RestController
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


    /**
     * 检查出场的车辆信息
     *
     * @param pointNo   点位编号
     * @param rfidTagNo 标签编号
     * @return 统一返回信息
     */
    @GetMapping("/doCheck")
    public ResponseInfo doCheck(@RequestParam("pointNo") String pointNo, @RequestParam("rfidTagNo") String rfidTagNo
            , @RequestParam("checkType") Integer checkType) {
        return service.doCheck(pointNo, rfidTagNo, checkType == 1 ? true : false);
    }

}
