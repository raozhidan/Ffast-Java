package com.feiduyang.pay.web.service.impl.management;

import com.feiduyang.core.support.CrudServiceImpl;
import com.feiduyang.web.dao.management.PayFlowMapper;
import com.feiduyang.web.entity.management.PayFlow;
import com.feiduyang.web.service.management.IPayFlowService;
import org.springframework.stereotype.Service;

/**
 * @description: 支付流水信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class PayFlowServiceImpl extends CrudServiceImpl<PayFlowMapper, PayFlow, Long> implements IPayFlowService {

}
