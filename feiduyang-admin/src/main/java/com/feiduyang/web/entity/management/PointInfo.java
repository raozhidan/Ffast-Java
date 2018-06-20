package com.feiduyang.web.entity.management;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.feiduyang.core.support.BaseEntity;

import java.math.BigDecimal;

/**
 * @description: 商户的点位信息
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@TableName(value = "t_point_info", resultMap = "BaseResultMap")
public class PointInfo extends BaseEntity<PointInfo> {

    private static final long serialVersionUID = 1L;
    /**
     * 点位名称
     */
    @TableField("point_name")
    private String pointName;
    /**
     * 点位编号
     */
    @TableField("point_no")
    private String pointNo;
    /**
     * 点位地址
     */
    @TableField("point_address")
    private String pointAddress;
    /**
     * 点位地址编码
     */
    @TableField("point_address_code")
    private String pointAddressCode;
    /**
     * 点位设备编号
     */
    @TableField("point_device_no")
    private String pointDeviceNo;
    /**
     * 点位所属商户
     */
    @TableField("point_business_id")
    private Long pointBusinessId;
    /**
     * 点位维护人员
     */
    @TableField("point_maintenance_person")
    private String pointMaintenancePerson;
    /**
     * 点位维护人员电话
     */
    @TableField("point_maintenance_person_phone")
    private String pointMaintenancePersonPhone;
    /**
     * 点位所属单位
     */
    @TableField("point_charge_company")
    private String pointChargeCompany;
    /**
     * 点位规模（有多少辆车）
     */
    @TableField("point_capacity")
    private Integer pointCapacity;
    /**
     * 点位状态
     */
    @TableField("point_status")
    private Integer pointStatus;
    /**
     * 点位临时停车费用
     */
    @TableField("point_temporary_fee")
    private BigDecimal pointTemporaryFee;

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getPointNo() {
        return pointNo;
    }

    public void setPointNo(String pointNo) {
        this.pointNo = pointNo;
    }

    public String getPointAddress() {
        return pointAddress;
    }

    public void setPointAddress(String pointAddress) {
        this.pointAddress = pointAddress;
    }

    public String getPointAddressCode() {
        return pointAddressCode;
    }

    public void setPointAddressCode(String pointAddressCode) {
        this.pointAddressCode = pointAddressCode;
    }

    public String getPointDeviceNo() {
        return pointDeviceNo;
    }

    public void setPointDeviceNo(String pointDeviceNo) {
        this.pointDeviceNo = pointDeviceNo;
    }

    public Long getPointBusinessId() {
        return pointBusinessId;
    }

    public void setPointBusinessId(Long pointBusinessId) {
        this.pointBusinessId = pointBusinessId;
    }

    public String getPointMaintenancePerson() {
        return pointMaintenancePerson;
    }

    public void setPointMaintenancePerson(String pointMaintenancePerson) {
        this.pointMaintenancePerson = pointMaintenancePerson;
    }

    public String getPointMaintenancePersonPhone() {
        return pointMaintenancePersonPhone;
    }

    public void setPointMaintenancePersonPhone(String pointMaintenancePersonPhone) {
        this.pointMaintenancePersonPhone = pointMaintenancePersonPhone;
    }

    public String getPointChargeCompany() {
        return pointChargeCompany;
    }

    public void setPointChargeCompany(String pointChargeCompany) {
        this.pointChargeCompany = pointChargeCompany;
    }

    public Integer getPointCapacity() {
        return pointCapacity;
    }

    public void setPointCapacity(Integer pointCapacity) {
        this.pointCapacity = pointCapacity;
    }

    public Integer getPointStatus() {
        return pointStatus;
    }

    public void setPointStatus(Integer pointStatus) {
        this.pointStatus = pointStatus;
    }

    public BigDecimal getPointTemporaryFee() {
        return pointTemporaryFee;
    }

    public void setPointTemporaryFee(BigDecimal pointTemporaryFee) {
        this.pointTemporaryFee = pointTemporaryFee;
    }


}
