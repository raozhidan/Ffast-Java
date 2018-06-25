package com.feiduyang.web.service.impl.management;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.feiduyang.core.support.CrudServiceImpl;
import com.feiduyang.core.utils.DateUtil;
import com.feiduyang.core.vo.ResponseInfo;
import com.feiduyang.web.dao.management.VehicleCheckInOutFlowMapper;
import com.feiduyang.web.entity.management.*;
import com.feiduyang.web.service.management.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 车辆进出流水信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class VehicleCheckInOutFlowServiceImpl extends CrudServiceImpl<VehicleCheckInOutFlowMapper, VehicleCheckInOutFlow, Long> implements IVehicleCheckInOutFlowService {


    @Autowired
    IPointInfoService pointInfoService;

    @Autowired
    IRfidTagInfoService rfidTagInfoService;

    @Autowired
    INonMotorizedVehicleInfoService vehicleInfoService;

    @Autowired
    IVehicleOwnerInfoService ownerInfoService;

    @Autowired
    IOwnerProductInfoService ownerProductInfoService;

    @Override
    public ResponseInfo doCheck(String poingNo, String rfidTagNo) {
        ResponseInfo responseInfo = new ResponseInfo();
        EntityWrapper<PointInfo> params = new EntityWrapper<>();
        params.eq("point_no", poingNo);
        PointInfo pointInfo = pointInfoService.selectOne(params);
        if (pointInfo == null) {
            return responseInfo.setSuccess(false).setErrNo(1);
        }
        //找出该标签所绑定的车辆及车主信息
        NonMotorizedVehicleInfo vehicleInfo = vehicleInfoService.selectOne(new EntityWrapper<NonMotorizedVehicleInfo>().eq("vehicle_tag_no", rfidTagNo));
        if (vehicleInfo == null) {
            return responseInfo.setSuccess(false).setErrNo(1);
        }
        VehicleOwnerInfo ownerInfo = ownerInfoService.findById(vehicleInfo.getVehicleOwnerId());
        if (ownerInfo == null) {
            return responseInfo.setSuccess(false).setErrNo(1);
        }
        //找出该车主是否购买有该点位相应的产品信息，没有的话就需要进行付费，按照该点位设置的临时停车进行付费
        //根据车主id，车辆id查找有效的产品
        List<OwnerProductInfo> ownerProductInfos = ownerProductInfoService.selectList(new EntityWrapper<OwnerProductInfo>().eq("vehicle_id", vehicleInfo.getId())
                .eq("owner_id", ownerInfo.getId()).eq("owner_product_status", 0));
        //若能够找到该车辆在该点位购买了产品，则进一步判断这些产品是否还在有效期之内
        boolean isPassCheck = false;
        if (!ownerProductInfos.isEmpty()) {
            for (OwnerProductInfo ownerProductInfo : ownerProductInfos) {
                int i = DateUtil.compareNow(ownerProductInfo.getProductExpirationTime());
                if (i > 0) {
                    //说明有产品尚在有效期内
                    isPassCheck = true;
                    break;
                }
                continue;
            }
        }
        if (!isPassCheck) {
            //未通过的情况
        }
        return new ResponseInfo(true).addData("isPassCheck", isPassCheck);
    }
}
