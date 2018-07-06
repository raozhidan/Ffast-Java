package com.feiduyang.web.entity.management;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.feiduyang.core.support.BaseEntity;

import java.math.BigDecimal;

/**
 * @description: 订单信息
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@TableName(value = "t_orders", resultMap = "BaseResultMap")
public class Orders extends BaseEntity<Orders> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @TableField("order_no")
    private String orderNo;
    /**
     * 产品id
     */
    @TableField("product_id")
    private Long productId;
    /**
     * 产品名称
     */
    @TableField("product_name")
    private String productName;
    /**
     * 订单状态（1 待支付 2已支付 3 支付失败）
     */
    @TableField("order_status")
    private Integer orderStatus;
    /**
     * 订单价格
     */
    @TableField("order_price")
    private BigDecimal orderPrice;
    /**
     * 产品数量
     */
    @TableField("product_num")
    private Integer productNum;
    /**
     * 购买用户
     */
    @TableField("owner_id")
    private Long ownerId;

    /**
     * 订单类型（1 商品购买 2 停车支付）
     */
    private Integer orderType;

    /**
     * 微信订单号
     */
    private String transactionId;

    /**
     * 支付方式（1微信 2 支付宝 3 银联）
     */
    private Integer payType;


    /**
     * 用户标识
     */
    private String openId;


    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }


}
