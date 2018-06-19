package com.feiduyang.web.entity.management;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.feiduyang.core.support.BaseManagementEntity;

/**
 * @description: 商户信息
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@TableName(value = "t_business_info", resultMap = "BaseResultMap")
public class BusinessInfo extends BaseManagementEntity<BusinessInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 商户编号
     */
    @TableField("business_no")
    private String businessNo;
    /**
     * 商户名称
     */
    @TableField("business_name")
    private String businessName;
    /**
     * 商户联系人
     */
    @TableField("business_person_name")
    private String businessPersonName;
    /**
     * 商户联系电话
     */
    @TableField("business_phone")
    private String businessPhone;
    /**
     * 商户所属渠道
     */
    @TableField("business_channel_id")
    private Long businessChannelId;
    /**
     * 商户地址
     */
    @TableField("business_address")
    private String businessAddress;
    /**
     * 商户信用代码
     */
    @TableField("business_society_code")
    private String businessSocietyCode;
    /**
     * 商户所在地区编码
     */
    @TableField("business_address_code")
    private String businessAddressCode;
    /**
     * 商户状态
     */
    @TableField("business_status")
    private Integer businessStatus;

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessPersonName() {
        return businessPersonName;
    }

    public void setBusinessPersonName(String businessPersonName) {
        this.businessPersonName = businessPersonName;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public Long getBusinessChannelId() {
        return businessChannelId;
    }

    public void setBusinessChannelId(Long businessChannelId) {
        this.businessChannelId = businessChannelId;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessSocietyCode() {
        return businessSocietyCode;
    }

    public void setBusinessSocietyCode(String businessSocietyCode) {
        this.businessSocietyCode = businessSocietyCode;
    }

    public String getBusinessAddressCode() {
        return businessAddressCode;
    }

    public void setBusinessAddressCode(String businessAddressCode) {
        this.businessAddressCode = businessAddressCode;
    }

    public Integer getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(Integer businessStatus) {
        this.businessStatus = businessStatus;
    }


}
