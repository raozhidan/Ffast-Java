package com.feiduyang.web.service.impl.management;

import com.feiduyang.core.support.CrudServiceImpl;
import com.feiduyang.core.vo.ServiceRowsResult;
import com.feiduyang.web.dao.management.PointInfoMapper;
import com.feiduyang.web.entity.management.BusinessInfo;
import com.feiduyang.web.entity.management.PointInfo;
import com.feiduyang.web.service.management.IBusinessInfoService;
import com.feiduyang.web.service.management.IPointInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 商户的点位信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class PointInfoServiceImpl extends CrudServiceImpl<PointInfoMapper, PointInfo, Long> implements IPointInfoService {

    @Autowired
    IBusinessInfoService businessInfoService;

    @Override
    protected ServiceRowsResult listAfter(PointInfo m, List<PointInfo> resultList) {
        if (resultList != null) {
            for (PointInfo pointInfo : resultList) {
                BusinessInfo businessInfo = businessInfoService.findById(pointInfo.getPointBusinessId());
                if (businessInfo != null) {
                    pointInfo.setPointBusinessName(businessInfo.getBusinessName());
                }
            }
        }
        return super.listAfter(m, resultList);
    }
}
