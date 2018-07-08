package com.feiduyang.pay.web.dao.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feiduyang.web.entity.sys.Role;
import com.feiduyang.web.entity.sys.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 系统_用户角色Mapper接口
 * @copyright:
 * @createTime: 2017年08月31日 09:49:42
 * @author: dzy
 * @version: 1.0
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
    /**
     * 根据用户id获得角色列表
     *
     * @param userId
     * @param roleId
     * @return
     */
    List<Role> listByUserId(@Param("userId") Long userId, @Param("roleId") Long roleId);
}