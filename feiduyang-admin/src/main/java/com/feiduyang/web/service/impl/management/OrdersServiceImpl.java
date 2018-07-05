package com.feiduyang.web.service.impl.management;

import com.feiduyang.core.support.CrudServiceImpl;
import com.feiduyang.core.vo.ResponseInfo;
import com.feiduyang.web.dao.management.OrdersMapper;
import com.feiduyang.web.entity.management.Orders;
import com.feiduyang.web.service.management.IOrdersService;
import org.springframework.stereotype.Service;

/**
 * @description: 订单信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class OrdersServiceImpl extends CrudServiceImpl<OrdersMapper, Orders, Long> implements IOrdersService {


    @Override
    protected ResponseInfo createAfter(Orders m) {
        //创建订单后，请求实际支付渠道，先用微信支付
        return super.createAfter(m);
    }
}
