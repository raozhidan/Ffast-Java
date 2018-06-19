package com.feiduyang.web.controller.sys;

import com.feiduyang.core.annotations.Logined;
import com.feiduyang.core.annotations.Permission;
import com.feiduyang.core.vo.ResponseInfo;
import com.feiduyang.web.entity.sys.Dict;
import com.feiduyang.web.service.sys.IDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

import com.feiduyang.core.support.BaseCrudController;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 字典数据接口
 * @copyright:
 * @createTime: 2017-09-13 09:14:49
 * @author: dzy
 * @version: 1.0
 */
@Logined
@Controller
@RequestMapping("/api/sys/dict")
@Permission(value = "dict")
public class DictController extends BaseCrudController<Dict,IDictService,Long> {

    private static Logger logger = LoggerFactory.getLogger(DictController.class);

    @Resource
    private IDictService service;

    @Override
    protected IDictService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


    /**
     * 获得字典
     * @param type
     * @param isName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get")
    public ResponseInfo getDict(String type, Boolean isName){
        return getService().getDict(type,isName);
    }
}
