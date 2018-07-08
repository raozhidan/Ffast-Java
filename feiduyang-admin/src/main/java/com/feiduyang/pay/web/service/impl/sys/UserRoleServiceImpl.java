package com.feiduyang.pay.web.service.impl.sys;

import com.feiduyang.core.support.CrudServiceImpl;
import com.feiduyang.pay.web.dao.sys.UserRoleMapper;
import com.feiduyang.pay.web.entity.sys.Role;
import com.feiduyang.pay.web.service.sys.IUserRoleService;
import com.feiduyang.web.entity.sys.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 系统_用户角色服务实现类
 * @copyright:
 * @createTime: 2017年08月31日 09:49:42
 * @author: dzy
 * @version: 1.0
 */
@Service
public class UserRoleServiceImpl extends CrudServiceImpl<UserRoleMapper, UserRole, Long> implements IUserRoleService {

    @Resource
    UserRoleMapper userRoleMapper;

    @Override
    public List<Role> listByUserId(Long userId, Long roleId) {
        return userRoleMapper.listByUserId(userId, roleId);
    }
}
