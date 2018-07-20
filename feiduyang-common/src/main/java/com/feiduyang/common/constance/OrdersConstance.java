package com.feiduyang.common.constance;

/**
 * 订单相关常量
 *
 * @author 45984（rao.zhidan@sccaptain.com.cn）
 * @create 2018/7/4
 */
public interface OrdersConstance {
    interface OrderType {
        /**
         * 商品购买
         */
        Integer BUY_PRODUCT = 1;
        /**
         * 临时停车
         */
        Integer TEMPORY_FEE = 2;
    }

    /**
     * 支付方式
     */
    interface PayType {
        /**
         * 微信支付
         */
        Integer WECHAT_PAY = 1;
        /**
         * 支付宝
         */
        Integer ALI_PAY = 2;
        /**
         * 银联支付
         */
        Integer UNION_PAY = 3;
    }
}
