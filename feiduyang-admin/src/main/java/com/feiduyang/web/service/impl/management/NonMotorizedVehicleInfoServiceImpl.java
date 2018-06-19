package com.feiduyang.web.service.impl.management;

import com.feiduyang.core.support.CrudServiceImpl;
import com.feiduyang.web.dao.management.NonMotorizedVehicleInfoMapper;
import com.feiduyang.web.entity.management.NonMotorizedVehicleInfo;
import com.feiduyang.web.service.management.INonMotorizedVehicleInfoService;
import org.springframework.stereotype.Service;

/**
 * @description: 非机动车信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class NonMotorizedVehicleInfoServiceImpl extends CrudServiceImpl<NonMotorizedVehicleInfoMapper, NonMotorizedVehicleInfo, Long> implements INonMotorizedVehicleInfoService {

}
