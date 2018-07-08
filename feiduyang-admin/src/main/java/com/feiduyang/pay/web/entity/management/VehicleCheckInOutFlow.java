package com.feiduyang.pay.web.entity.management;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.feiduyang.core.support.BaseEntity;

import java.util.Date;

/**
 * @description: 车辆进出流水信息
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@TableName(value = "t_vehicle_check_in_out_flow", resultMap = "BaseResultMap")
public class VehicleCheckInOutFlow extends BaseEntity<VehicleCheckInOutFlow> {

    private static final long serialVersionUID = 1L;

    /**
     * 车辆id
     */
    @TableField("vehicle_id")
    private Long vehicleId;
    /**
     * 进入场地id
     */
    @TableField("point_id")
    private Long pointId;
    /**
     * 进场还是出场（0 进场，1 出场）
     */
    @TableField("check_type")
    private Integer checkType;
    /**
     * 进场时间
     */
    @TableField(value = "check_in_time", fill = FieldFill.INSERT)
    private Date checkInTime;
    /**
     * 出场时间
     */
    @TableField(value = "check_out_time", fill = FieldFill.INSERT_UPDATE, update = "now()")
    private Date checkOutTime;
    /**
     * 该车辆该次所使用的产品id（0 默认为不使用，即为临时停车）
     */
    @TableField("check_use_product_id")
    private Long checkUseProductId;

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }


    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Long getCheckUseProductId() {
        return checkUseProductId;
    }

    public void setCheckUseProductId(Long checkUseProductId) {
        this.checkUseProductId = checkUseProductId;
    }


}
