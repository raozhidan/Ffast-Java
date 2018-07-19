package com.feiduyang.api.sys;


import com.feiduyang.common.entity.sys.Role;
import com.feiduyang.common.entity.sys.UserRole;
import com.feiduyang.common.support.ICrudService;

import java.util.List;

/**
 * @description: 系统_用户角色服务类
 * @copyright:
 * @createTime: 2017年08月31日 09:49:42
 * @author: dzy
 * @version: 1.0
 */
public interface IUserRoleService extends ICrudService<UserRole, Long> {
    List<Role> listByUserId(Long userId, Long roleId);
}
