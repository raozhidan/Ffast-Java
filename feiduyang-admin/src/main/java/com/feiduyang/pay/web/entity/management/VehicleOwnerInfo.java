package com.feiduyang.pay.web.entity.management;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.feiduyang.core.support.BaseEntity;

/**
 * @description: 车主信息
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@TableName(value = "t_vehicle_owner_info", resultMap = "BaseResultMap")
public class VehicleOwnerInfo extends BaseEntity<VehicleOwnerInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 车主姓名
     */
    @TableField("owner_name")
    private String ownerName;
    /**
     * 车主电话
     */
    @TableField("owner_phone")
    private String ownerPhone;
    /**
     * 车主证件号
     */
    @TableField("owner_card_no")
    private String ownerCardNo;
    /**
     * 车主状态
     */
    @TableField("owner_status")
    private Integer ownerStatus;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerCardNo() {
        return ownerCardNo;
    }

    public void setOwnerCardNo(String ownerCardNo) {
        this.ownerCardNo = ownerCardNo;
    }

    public Integer getOwnerStatus() {
        return ownerStatus;
    }

    public void setOwnerStatus(Integer ownerStatus) {
        this.ownerStatus = ownerStatus;
    }


}
