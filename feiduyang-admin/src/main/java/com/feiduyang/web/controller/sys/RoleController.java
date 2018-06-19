package com.feiduyang.web.controller.sys;


import com.feiduyang.core.annotations.Logined;
import com.feiduyang.core.annotations.Permission;
import com.feiduyang.core.support.BaseCrudController;
import com.feiduyang.web.entity.sys.Role;
import com.feiduyang.web.service.sys.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


/**
 * @description: 系统_角色数据接口
 * @copyright:
 * @createTime: 2017-09-13 09:14:49
 * @author: dzy
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/sys/role")
@Logined
@Permission(value = "role")
public class RoleController extends BaseCrudController<Role, IRoleService, Long> {

    private static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Resource
    private IRoleService service;

    @Override
    protected IRoleService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

}
