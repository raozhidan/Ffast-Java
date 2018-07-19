package com.feiduyang.web.service.impl.management;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.feiduyang.api.management.IBusinessInfoService;
import com.feiduyang.api.management.IPointInfoService;
import com.feiduyang.common.entity.management.BusinessInfo;
import com.feiduyang.common.entity.management.PointInfo;
import com.feiduyang.common.support.CrudServiceImpl;
import com.feiduyang.common.vo.ServiceRowsResult;
import com.feiduyang.web.dao.management.PointInfoMapper;
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
    protected ServiceRowsResult listBefore(PointInfo m, EntityWrapper<PointInfo> ew) {
        ew.eq("point_business_id", "");
        return super.listBefore(m, ew);
    }

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
