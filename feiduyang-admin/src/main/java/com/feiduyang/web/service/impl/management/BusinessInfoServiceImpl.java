package com.feiduyang.web.service.impl.management;

import com.feiduyang.core.support.CrudServiceImpl;
import com.feiduyang.web.dao.management.BusinessInfoMapper;
import com.feiduyang.web.entity.management.BusinessInfo;
import com.feiduyang.web.service.management.IBusinessInfoService;
import org.springframework.stereotype.Service;

/**
 * @description: 商户信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class BusinessInfoServiceImpl extends CrudServiceImpl<BusinessInfoMapper, BusinessInfo, Long> implements IBusinessInfoService {

}
