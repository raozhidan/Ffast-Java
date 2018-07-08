package com.feiduyang.pay.web.entity.management;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.feiduyang.core.support.BaseEntity;

import java.util.Date;

/**
 * @description: 车主购买的套餐产品信息
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@TableName(value = "t_owner_product_info", resultMap = "BaseResultMap")
public class OwnerProductInfo extends BaseEntity<OwnerProductInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 点位id
     */
    @TableField("point_id")
    private Long pointId;
    /**
     * 产品id
     */
    @TableField("product_id")
    private Long productId;
    /**
     * 车辆id
     */
    @TableField("vehicle_id")
    private Long vehicleId;
    /**
     * 车主id
     */
    @TableField("owner_id")
    private Long ownerId;
    /**
     * 产品过期时间
     */
    @TableField("product_expiration_time")
    private Date productExpirationTime;
    /**
     * 状态
     */
    @TableField("owner_product_status")
    private Integer ownerProductStatus;

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Date getProductExpirationTime() {
        return productExpirationTime;
    }

    public void setProductExpirationTime(Date productExpirationTime) {
        this.productExpirationTime = productExpirationTime;
    }

    public Integer getOwnerProductStatus() {
        return ownerProductStatus;
    }

    public void setOwnerProductStatus(Integer ownerProductStatus) {
        this.ownerProductStatus = ownerProductStatus;
    }


}
