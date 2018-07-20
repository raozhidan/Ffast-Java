package com.feiduyang.web.service.impl.management;


import com.feiduyang.api.management.IProductInfoService;
import com.feiduyang.common.entity.management.ProductInfo;
import com.feiduyang.common.support.CrudServiceImpl;
import com.feiduyang.web.dao.management.ProductInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @description: 产品信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class ProductInfoServiceImpl extends CrudServiceImpl<ProductInfoMapper, ProductInfo, Long> implements IProductInfoService {

}
