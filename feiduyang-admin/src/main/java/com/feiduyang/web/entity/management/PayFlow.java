package com.feiduyang.web.entity.management;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.feiduyang.core.support.BaseEntity;

import java.math.BigDecimal;

/**
 * @description: 支付流水信息
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@TableName(value = "t_pay_flow", resultMap = "BaseResultMap")
public class PayFlow extends BaseEntity<PayFlow> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableField("order_id")
    private Long orderId;
    /**
     * 订单编号
     */
    @TableField("order_no")
    private String orderNo;
    /**
     * 支付金额
     */
    @TableField("pay_money")
    private BigDecimal payMoney;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }


}
