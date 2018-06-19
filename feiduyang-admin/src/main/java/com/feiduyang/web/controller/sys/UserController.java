package com.feiduyang.web.controller.sys;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.feiduyang.core.annotations.Logined;
import com.feiduyang.core.annotations.Permission;
import com.feiduyang.core.auth.OperatorUtils;
import com.feiduyang.core.support.BaseCrudController;
import com.feiduyang.core.utils.FStringUtil;
import com.feiduyang.core.vo.ResponseInfo;
import com.feiduyang.web.entity.sys.User;
import com.feiduyang.web.entity.sys.UserRole;
import com.feiduyang.web.service.sys.IUserRoleService;
import com.feiduyang.web.service.sys.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @description: 系统_用户数据接口
 * @copyright:
 * @createTime: 2017-09-13 09:14:49
 * @author: dzy
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/sys/user")
@Logined
@Permission(value = "user")
public class UserController extends BaseCrudController<User, IUserService, Long> {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserService service;
    @Resource
    private IUserRoleService userRoleService;

    @Resource
    private OperatorUtils operatorUtils;

    @Override
    protected IUserService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    protected void createAfter(User m, ResponseInfo result) {
        updateRole(m, result);
    }

    @Override
    protected void updateAfter(User m, ResponseInfo result) {
        updateRole(m, result);
    }


    /**
     * 更新角色
     *
     * @param m
     * @param result
     */
    private void updateRole(User m, ResponseInfo result) {
        if (!StringUtils.isEmpty(m.getRoleId()) && m.getId() != null) {
            String[] idArray = FStringUtil.split(m.getRoleId(), ",");
            Long creatorId = getLoginUserId();
            List<UserRole> urList = new ArrayList<>();
            for (int i = 0; i < idArray.length; i++) {
                UserRole ur = new UserRole();
                ur.setUserId(m.getId());
                ur.setRoleId(new Long(idArray[i]));
                ur.setCreatorId(creatorId);
                urList.add(ur);
            }
            EntityWrapper ew = new EntityWrapper<User>();
            ew.eq("user_id", m.getId());
            userRoleService.delete(ew);
            userRoleService.insertBatch(urList);
        }
    }

    /**
     * 重置密码
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/reseting", method = RequestMethod.POST)
    @ResponseBody
    @Permission("reseting")
    public ResponseInfo resetting(Long id) {
        ResponseInfo result = getService().reseting(id);
        return result;
    }

    /**
     * 修改密码
     *
     * @param pwd     原密码
     * @param newpwd  新密码
     * @param newpwd2 重复新密码
     * @return
     */
    @RequestMapping(value = "/respwd", method = RequestMethod.POST)
    @ResponseBody
    public ResponseInfo respwd(String pwd, String newpwd, String newpwd2) {
        // Demo限制（可以删除）：不允许修改超级管理员账户
        if (operatorUtils.getLoginUserId().intValue() == 1) {
            return new ResponseInfo(false).setMessage("不能修改超级管理员账户");
        }
        return service.respwd(operatorUtils.getLoginUserId(), pwd, newpwd, newpwd2);
    }


    @Override
    protected ResponseInfo updateBefore(User m) {
        // Demo限制（可以删除）：修改用户前判断，不允许修改admin账户
        if (m.getId() == 1) {
            return new ResponseInfo(false).setMessage("不能修改admin");
        }
        return null;
    }


}
