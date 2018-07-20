package com.feiduyang.web.service.impl.management;

import com.feiduyang.api.management.INonMotorizedVehicleInfoService;
import com.feiduyang.api.management.IVehicleOwnerInfoService;
import com.feiduyang.common.entity.management.NonMotorizedVehicleInfo;
import com.feiduyang.common.entity.management.VehicleOwnerInfo;
import com.feiduyang.common.support.CrudServiceImpl;
import com.feiduyang.common.vo.ServiceRowsResult;
import com.feiduyang.web.dao.management.NonMotorizedVehicleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 非机动车信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class NonMotorizedVehicleInfoServiceImpl extends CrudServiceImpl<NonMotorizedVehicleInfoMapper, NonMotorizedVehicleInfo, Long> implements INonMotorizedVehicleInfoService {

    @Autowired
    IVehicleOwnerInfoService vehicleOwnerInfoService;

    @Override
    protected ServiceRowsResult listAfter(NonMotorizedVehicleInfo m, List<NonMotorizedVehicleInfo> resultList) {
        if (!resultList.isEmpty()) {
            VehicleOwnerInfo ownerInfo;
            for (NonMotorizedVehicleInfo vehicleInfo : resultList) {
                ownerInfo = vehicleOwnerInfoService.findById(vehicleInfo.getVehicleOwnerId());
                if (ownerInfo != null) {
                    vehicleInfo.setOwnerName(ownerInfo.getOwnerName());
                }
            }
        }
        return super.listAfter(m, resultList);
    }
}
