package com.feiduyang.web.controller.sys;

import com.feiduyang.core.annotations.Logined;
import com.feiduyang.core.annotations.Permission;
import com.feiduyang.core.support.BaseCrudController;
import com.feiduyang.web.entity.sys.Log;
import com.feiduyang.web.service.sys.ILogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description: 操作日志表数据接口
 * @copyright:
 * @createTime: 2017-11-14 14:48:11
 * @author: dzy
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/sys/log")
@Logined
@Permission(value = "sysLog")
public class LogController extends BaseCrudController<Log, ILogService, Long> {

    private static Logger logger = LoggerFactory.getLogger(ResController.class);

    @Resource
    private ILogService service;

    @Override
    protected ILogService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
