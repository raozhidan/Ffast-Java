package com.feiduyang.api.management;

import com.feiduyang.common.entity.management.VehicleCheckInOutFlow;
import com.feiduyang.common.support.ICrudService;
import com.feiduyang.common.vo.ResponseInfo;

/**
 * @description: 车辆进出流水信息服务类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
public interface IVehicleCheckInOutFlowService extends ICrudService<VehicleCheckInOutFlow, Long> {

    ResponseInfo doCheck(String pointNo, String rfidTagNo, Boolean isCheckIn);
}
