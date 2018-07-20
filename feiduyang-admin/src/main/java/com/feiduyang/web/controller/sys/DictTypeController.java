package com.feiduyang.web.controller.sys;

import com.feiduyang.api.sys.IDictTypeService;
import com.feiduyang.common.annotations.Logined;
import com.feiduyang.common.annotations.Permission;
import com.feiduyang.common.entity.sys.DictType;
import com.feiduyang.common.support.BaseCrudController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description: 基础字典类型数据接口
 * @copyright:
 * @createTime: 2017-09-13 09:14:49
 * @author: dzy
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/sys/dictType")
@Logined
@Permission(value = "dict")
public class DictTypeController extends BaseCrudController<DictType, IDictTypeService, Long> {

    private static Logger logger = LoggerFactory.getLogger(DictTypeController.class);

    @Resource
    private IDictTypeService service;

    @Override
    protected IDictTypeService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
