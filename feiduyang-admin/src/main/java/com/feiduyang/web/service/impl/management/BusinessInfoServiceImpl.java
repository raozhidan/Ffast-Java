package com.feiduyang.web.service.impl.management;

import com.feiduyang.core.support.CrudServiceImpl;
import com.feiduyang.core.vo.ResponseInfo;
import com.feiduyang.core.vo.ServiceRowsResult;
import com.feiduyang.web.dao.management.BusinessInfoMapper;
import com.feiduyang.web.entity.management.BusinessInfo;
import com.feiduyang.web.entity.management.ChannelInfo;
import com.feiduyang.web.service.management.IBusinessInfoService;
import com.feiduyang.web.service.management.IChannelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 商户信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class BusinessInfoServiceImpl extends CrudServiceImpl<BusinessInfoMapper, BusinessInfo, Long> implements IBusinessInfoService {

    @Autowired
    IChannelInfoService channelInfoService;

    @Override
    protected ResponseInfo createAfter(BusinessInfo m) {
        //创建成功之后初始化该商户的账户信息
        return super.createAfter(m);
    }

    @Override
    protected ServiceRowsResult listAfter(BusinessInfo m, List<BusinessInfo> resultList) {
        if (!resultList.isEmpty()) {
            for (BusinessInfo businessInfo : resultList) {
                ChannelInfo channelInfo = channelInfoService.findById(businessInfo.getBusinessChannelId());
                if (channelInfo != null) {
                    businessInfo.setBusinessChannelName(channelInfo.getChannelName());
                }
            }
        }
        return super.listAfter(m, resultList);
    }
}
