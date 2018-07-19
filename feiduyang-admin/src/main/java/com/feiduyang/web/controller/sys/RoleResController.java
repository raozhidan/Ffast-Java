package com.feiduyang.web.controller.sys;

import com.feiduyang.api.sys.IResService;
import com.feiduyang.api.sys.IRoleResService;
import com.feiduyang.common.annotations.Logined;
import com.feiduyang.common.annotations.Permission;
import com.feiduyang.common.entity.sys.RoleRes;
import com.feiduyang.common.support.BaseCrudController;
import com.feiduyang.common.vo.ResponseInfo;
import com.feiduyang.common.vo.ServiceRowsResult;
import com.feiduyang.core.auth.OperatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @description: 系统_角色资源数据接口
 * @copyright:
 * @createTime: 2017-09-13 09:14:49
 * @author: dzy
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/sys/roleRes")
@Logined
@Permission(value = "roleRes")
public class RoleResController extends BaseCrudController<RoleRes, IRoleResService, Long> {

    private static Logger logger = LoggerFactory.getLogger(RoleResController.class);

    @Resource
    private IRoleResService service;
    @Resource
    private IResService resService;

    @Override
    protected IRoleResService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Resource
    private OperatorUtils operatorUtils;

    /**
     * 保存角色资源菜单
     *
     * @param ids
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveRes")
    public ResponseInfo saveRes(String ids, Long roleId) {
        // Demo限制（可以删除）：不允许修改超级管理员账户
//        if (roleId.intValue() == 1) {
//            return new ResponseInfo(false).setMessage("不能修改超级管理员账户");
//        }
        return service.saveRes(ids, roleId);
    }

    /**
     * 获得所有资源菜单与角色所拥有的资源列表
     *
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRoleRes")
    public ResponseInfo getRoleResIds(Long roleId) {
        ServiceRowsResult result = new ServiceRowsResult(false);
        result.addData("rows", resService.selectList(null, new String[]{"id", "name", "parent_id", "res_type"}));
        result.addData("selected", service.getRoleResIds(roleId));
        result.setSuccess(true);
        return result;
    }
}
