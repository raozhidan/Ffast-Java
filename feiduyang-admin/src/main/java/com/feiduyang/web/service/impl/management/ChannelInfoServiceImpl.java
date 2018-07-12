package com.feiduyang.web.service.impl.management;

import com.feiduyang.api.management.IChannelInfoService;
import com.feiduyang.common.entity.management.ChannelInfo;
import com.feiduyang.common.support.CrudServiceImpl;
import com.feiduyang.web.dao.management.ChannelInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @description: 渠道信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class ChannelInfoServiceImpl extends CrudServiceImpl<ChannelInfoMapper, ChannelInfo, Long> implements IChannelInfoService {

}
