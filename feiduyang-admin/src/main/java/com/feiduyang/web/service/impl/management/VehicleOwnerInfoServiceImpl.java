package com.feiduyang.web.service.impl.management;


import com.feiduyang.api.management.IVehicleOwnerInfoService;
import com.feiduyang.common.entity.management.VehicleOwnerInfo;
import com.feiduyang.common.support.CrudServiceImpl;
import com.feiduyang.web.dao.management.VehicleOwnerInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @description: 车主信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class VehicleOwnerInfoServiceImpl extends CrudServiceImpl<VehicleOwnerInfoMapper, VehicleOwnerInfo, Long> implements IVehicleOwnerInfoService {

}
