package com.feiduyang.web.service.impl.management;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.feiduyang.common.constance.OrdersConstance;
import com.feiduyang.common.utils.DateUtil;
import com.feiduyang.common.utils.MakeOrderNum;
import com.feiduyang.common.vo.ResponseInfo;
import com.feiduyang.core.support.CrudServiceImpl;
import com.feiduyang.web.dao.management.VehicleCheckInOutFlowMapper;
import com.feiduyang.web.entity.management.*;
import com.feiduyang.web.service.management.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    @Resource
    VehicleCheckInOutFlowMapper checkInOutFlowMapper;

    @Autowired
    IOrdersService ordersService;

    @Override
    public ResponseInfo doCheck(String pointNo, String rfidTagNo, Boolean isCheckIn) {
        ResponseInfo responseInfo = new ResponseInfo();
        EntityWrapper<PointInfo> params = new EntityWrapper<>();
        params.eq("point_no", pointNo);
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
        if (isCheckIn) {
            return checkIn(pointInfo, ownerInfo, vehicleInfo);
        } else {
            return checkOut(pointInfo, ownerInfo, vehicleInfo);
        }
    }

    /**
     * 车辆入场检查
     *
     * @param pointInfo   点位信息
     * @param ownerInfo   车主信息
     * @param vehicleInfo 车辆信息
     * @return 统一返回对象
     * @Author Zhidan.Rao
     * @Version 1.0.0
     */
    private ResponseInfo checkIn(PointInfo pointInfo, VehicleOwnerInfo ownerInfo,
                                 NonMotorizedVehicleInfo vehicleInfo) {
        ResponseInfo responseInfo = new ResponseInfo();
        VehicleCheckInOutFlow flow = new VehicleCheckInOutFlow();
        flow.setPointId(pointInfo.getId());
        flow.setVehicleId(vehicleInfo.getId());
        flow.setCheckInTime(new Date());
        checkInOutFlowMapper.insert(flow);
        return responseInfo.setSuccess(true).addData("isPassCheck", true);
    }

    /**
     * 车辆出场检查
     *
     * @param pointInfo   点位信息
     * @param ownerInfo   车主信息
     * @param vehicleInfo 车辆信息
     * @return 统一返回对象
     * @Author Zhidan.Rao
     * @Version 1.0.0
     */
    private ResponseInfo checkOut(PointInfo pointInfo, VehicleOwnerInfo ownerInfo,
                                  NonMotorizedVehicleInfo vehicleInfo) {
        ResponseInfo responseInfo = new ResponseInfo();

        //找出该车主是否购买有该点位相应的产品信息，没有的话就需要进行付费，按照该点位设置的临时停车进行付费
        //根据车主id，车辆id查找有效的产品
        List<OwnerProductInfo> ownerProductInfos = ownerProductInfoService.selectList(new EntityWrapper<OwnerProductInfo>().eq("vehicle_id", vehicleInfo.getId())
                .eq("owner_id", ownerInfo.getId()).eq("owner_product_status", 1));
        //若能够找到该车辆在该点位购买了产品，则进一步判断这些产品是否还在有效期之内
        boolean isPassCheck = false;
        Long productId = null;
        if (!ownerProductInfos.isEmpty()) {
            for (OwnerProductInfo ownerProductInfo : ownerProductInfos) {
                int i = DateUtil.compareNow(ownerProductInfo.getProductExpirationTime());
                if (i > 0) {
                    //说明有产品尚在有效期内
                    isPassCheck = true;
                    productId = ownerProductInfo.getProductId();
                    break;
                }
                continue;
            }
        }
        if (isPassCheck) {
            //通过的情况，要保存车辆的出场时间
            EntityWrapper<VehicleCheckInOutFlow> wrapper = new EntityWrapper<>();
            wrapper.eq("point_id", pointInfo.getId())
                    .eq("vehicle_id", vehicleInfo.getId()).orderBy("check_in_time", false);
            //找出最近的一条进场数据，然后更新
            List<VehicleCheckInOutFlow> vehicleCheckInOutFlows = checkInOutFlowMapper.selectList(wrapper);
            if (!vehicleCheckInOutFlows.isEmpty()) {
                VehicleCheckInOutFlow flow = vehicleCheckInOutFlows.get(0);
                flow.setCheckUseProductId(productId);
                flow.setCheckOutTime(new Date());
                checkInOutFlowMapper.updateById(flow);
            }
        } else {
            //若没有通过检查，则生成一份待支付订单，支付后方可出场
            Orders orders = new Orders();
            orders.setOrderNo(MakeOrderNum.makeOrderNum());
            //找出该点位当前设置的临时停车费用
            orders.setOrderPrice(pointInfo.getPointTemporaryFee());
            orders.setOrderStatus(1);
            orders.setOwnerId(ownerInfo.getId());
            orders.setProductId(0L);
            orders.setProductName(pointInfo.getPointName() + "非机动车临时停车费用");
            orders.setOrderType(OrdersConstance.OrderType.TEMPORY_FEE);
            orders.setPayType(OrdersConstance.PayType.WECHAT_PAY);
            ordersService.create(orders);
        }
        return responseInfo.setSuccess(true).addData("isPassCheck", isPassCheck);
    }
}
