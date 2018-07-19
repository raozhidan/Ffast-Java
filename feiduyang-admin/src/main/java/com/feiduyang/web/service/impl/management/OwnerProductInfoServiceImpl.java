package com.feiduyang.web.service.impl.management;

import com.feiduyang.api.management.IOwnerProductInfoService;
import com.feiduyang.common.entity.management.OwnerProductInfo;
import com.feiduyang.common.support.CrudServiceImpl;
import com.feiduyang.web.dao.management.OwnerProductInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @description: 车主购买的套餐产品信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class OwnerProductInfoServiceImpl extends CrudServiceImpl<OwnerProductInfoMapper, OwnerProductInfo, Long> implements IOwnerProductInfoService {

}
