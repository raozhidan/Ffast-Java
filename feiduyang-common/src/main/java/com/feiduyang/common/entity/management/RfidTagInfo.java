package com.feiduyang.common.entity.management;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.feiduyang.common.support.BaseEntity;

/**
 * @description: RFID标签信息
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@TableName(value = "t_rfid_tag_info", resultMap = "BaseResultMap")
public class RfidTagInfo extends BaseEntity<RfidTagInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 标签编号
     */
    @TableField("tag_no")
    private String tagNo;
    /**
     * 标签注册点位
     */
    @TableField("tag_reg_point_id")
    private Long tagRegPointId;
    /**
     * 标签EPC区码
     */
    @TableField("tag_epc_code")
    private String tagEpcCode;
    /**
     * 标签TID码
     */
    @TableField("tag_tid_code")
    private String tagTidCode;
    /**
     * 标签用户区码
     */
    @TableField("tag_user_code")
    private String tagUserCode;
    /**
     * 标签注册ip
     */
    @TableField("tag_reg_ip_address")
    private String tagRegIpAddress;
    /**
     * 标签状态
     */
    @TableField("tag_status")
    private Integer tagStatus;

    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public Long getTagRegPointId() {
        return tagRegPointId;
    }

    public void setTagRegPointId(Long tagRegPointId) {
        this.tagRegPointId = tagRegPointId;
    }

    public String getTagEpcCode() {
        return tagEpcCode;
    }

    public void setTagEpcCode(String tagEpcCode) {
        this.tagEpcCode = tagEpcCode;
    }

    public String getTagTidCode() {
        return tagTidCode;
    }

    public void setTagTidCode(String tagTidCode) {
        this.tagTidCode = tagTidCode;
    }

    public String getTagUserCode() {
        return tagUserCode;
    }

    public void setTagUserCode(String tagUserCode) {
        this.tagUserCode = tagUserCode;
    }

    public String getTagRegIpAddress() {
        return tagRegIpAddress;
    }

    public void setTagRegIpAddress(String tagRegIpAddress) {
        this.tagRegIpAddress = tagRegIpAddress;
    }

    public Integer getTagStatus() {
        return tagStatus;
    }

    public void setTagStatus(Integer tagStatus) {
        this.tagStatus = tagStatus;
    }


}
