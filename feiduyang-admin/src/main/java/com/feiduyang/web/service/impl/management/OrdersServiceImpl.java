package com.feiduyang.web.service.impl.management;

import com.feiduyang.common.constance.CodeEnum;
import com.feiduyang.common.utils.MakeOrderNum;
import com.feiduyang.common.vo.ResponseInfo;
import com.feiduyang.core.auth.AuthCurrentUser;
import com.feiduyang.core.support.CrudServiceImpl;
import com.feiduyang.web.dao.management.OrdersMapper;
import com.feiduyang.web.entity.management.Orders;
import com.feiduyang.web.feign.PayFeignClient;
import com.feiduyang.web.service.management.IOrdersService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @description: 订单信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class OrdersServiceImpl extends CrudServiceImpl<OrdersMapper, Orders, Long> implements IOrdersService {


    @Resource
    PayFeignClient payFeignClient;


    @Override
    protected ResponseInfo createBefore(Orders m) {
        if (StringUtils.isEmpty(AuthCurrentUser.getUserCode())) {
            return ResponseInfo.createCodeEnum(CodeEnum.WECHAT_CODE_NULL);
        }
        m.setOrderNo(MakeOrderNum.makeOrderNum());
        m.setOrderStatus(1);
        return super.createBefore(m);
    }

    /**
     * 目前支持微信支付，先调用预下单接口生成预支付订单返回给前端使用
     *
     * @param m
     * @return
     */
    @Override
    protected ResponseInfo createAfter(Orders m) {
        //创建订单后，请求实际支付渠道，先用微信支付
        try {
            return payFeignClient.dopay(m.getOrderNo(), m.getOrderPrice() + "", AuthCurrentUser.getUserCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String testFeign() {
        try {
            ResponseInfo responseInfo = payFeignClient.dopay("2018070500101", "12", "011Zu2cH0sffai2yLK9H0DChcH0Zu2cw");
            System.out.println(responseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
