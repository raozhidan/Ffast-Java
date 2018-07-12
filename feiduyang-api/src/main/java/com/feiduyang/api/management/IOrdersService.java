package com.feiduyang.api.management;

import com.feiduyang.common.entity.management.Orders;
import com.feiduyang.common.support.ICrudService;

/**
 * @description: 订单信息服务类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
public interface IOrdersService extends ICrudService<Orders, Long> {

    String testFeign();
}
