package com.feiduyang.web.service.impl.management;


import com.feiduyang.api.management.IRfidTagInfoService;
import com.feiduyang.common.entity.management.RfidTagInfo;
import com.feiduyang.common.support.CrudServiceImpl;
import com.feiduyang.web.dao.management.RfidTagInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @description: RFID标签信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class RfidTagInfoServiceImpl extends CrudServiceImpl<RfidTagInfoMapper, RfidTagInfo, Long> implements IRfidTagInfoService {

}
