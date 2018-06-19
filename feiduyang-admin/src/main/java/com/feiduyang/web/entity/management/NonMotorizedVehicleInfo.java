package com.feiduyang.web.entity.management;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.feiduyang.core.support.BaseEntity;

/**
 * @description: 非机动车信息
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@TableName(value = "t_non_motorized_vehicle_info", resultMap = "BaseResultMap")
public class NonMotorizedVehicleInfo extends BaseEntity<NonMotorizedVehicleInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 车辆编号
     */
    @TableField("vehicle_no")
    private String vehicleNo;
    /**
     * 车牌号
     */
    @TableField("vehicle_card_no")
    private String vehicleCardNo;
    /**
     * 车辆绑定的标签信息
     */
    @TableField("vehicle_tag_id")
    private Long vehicleTagId;
    /**
     * 所属车主
     */
    @TableField("vehicle_owner_id")
    private Long vehicleOwnerId;
    /**
     * 绑定的标签编号
     */
    @TableField("vehicle_tag_no")
    private String vehicleTagNo;

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleCardNo() {
        return vehicleCardNo;
    }

    public void setVehicleCardNo(String vehicleCardNo) {
        this.vehicleCardNo = vehicleCardNo;
    }

    public Long getVehicleTagId() {
        return vehicleTagId;
    }

    public void setVehicleTagId(Long vehicleTagId) {
        this.vehicleTagId = vehicleTagId;
    }

    public Long getVehicleOwnerId() {
        return vehicleOwnerId;
    }

    public void setVehicleOwnerId(Long vehicleOwnerId) {
        this.vehicleOwnerId = vehicleOwnerId;
    }

    public String getVehicleTagNo() {
        return vehicleTagNo;
    }

    public void setVehicleTagNo(String vehicleTagNo) {
        this.vehicleTagNo = vehicleTagNo;
    }


}
