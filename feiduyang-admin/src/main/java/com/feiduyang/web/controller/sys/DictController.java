package com.feiduyang.web.controller.sys;

import com.feiduyang.api.sys.IDictService;
import com.feiduyang.common.annotations.Logined;
import com.feiduyang.common.annotations.Permission;
import com.feiduyang.common.entity.sys.Dict;
import com.feiduyang.common.support.BaseCrudController;
import com.feiduyang.common.vo.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
public class DictController extends BaseCrudController<Dict, IDictService, Long> {

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
     *
     * @param type
     * @param isName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get")
    public ResponseInfo getDict(String type, Boolean isName) {
        return getService().getDict(type, isName);
    }
}
