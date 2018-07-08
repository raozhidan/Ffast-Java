package com.feiduyang.pay.web.entity.management;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.feiduyang.core.support.BaseEntity;

import java.math.BigDecimal;

/**
 * @description: 产品信息
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@TableName(value = "t_product_info", resultMap = "BaseResultMap")
public class ProductInfo extends BaseEntity<ProductInfo> {

    private static final long serialVersionUID = 1L;

    @TableField("product_name")
    private String productName;
    /**
     * 有效期限（单位：月）
     */
    @TableField("product_expiration_date")
    private Integer productExpirationDate;
    /**
     * 产品价格（元）
     */
    @TableField("product_price")
    private BigDecimal productPrice;
    /**
     * 所属商户
     */
    @TableField("business_id")
    private Long businessId;
    /**
     * 产品类型
     */
    @TableField("product_type")
    private Integer productType;
    /**
     * 所属点位
     */
    @TableField("point_id")
    private Long pointId;
    /**
     * 产品折扣
     */
    @TableField("product_discount")
    private BigDecimal productDiscount;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductExpirationDate() {
        return productExpirationDate;
    }

    public void setProductExpirationDate(Integer productExpirationDate) {
        this.productExpirationDate = productExpirationDate;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public BigDecimal getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(BigDecimal productDiscount) {
        this.productDiscount = productDiscount;
    }


}
