package com.feiduyang.web.service.sys;

import com.feiduyang.core.support.ICrudService;
import com.feiduyang.core.vo.ResponseInfo;
import com.feiduyang.web.entity.sys.Res;
import com.feiduyang.web.entity.sys.RoleRes;
import com.feiduyang.web.vo.RoleMenuPerms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 系统_角色资源服务类
 * @copyright:
 * @createTime: 2017年08月31日 09:49:42
 * @author: dzy
 * @version: 1.0
 */
public interface IRoleResService extends ICrudService<RoleRes, Long> {
    /**
     * 根据角色ID获得菜单或权限列表
     *
     * @param roleId
     * @return
     */
    List<Res> getRoleResList(Long roleId, Integer resType);

    /**
     * 根据角色ID获得菜单或权限列表
     *
     * @param roleIds
     * @param resType
     * @return
     */
    List<Res> getRoleResList(String roleIds, Integer resType);

    /**
     * 根据角色ID获得菜单列表
     *
     * @param roleId
     * @return
     */
    List<Res> getRoleMenuList(Long roleId);

    /**
     * 根据角色ID获得权限集合
     *
     * @param roleId
     * @return
     */
    HashSet<String> getRolePermissionList(Long roleId);

    /**
     * 根据角色id获得权限集合和菜单列表
     *
     * @param roleIds
     */
    RoleMenuPerms getRoleMenuAndPerms(String roleIds);

    /**
     * 保存角色资源
     *
     * @param ids
     * @param roleId
     * @return
     */
    ResponseInfo saveRes(String ids, Long roleId);

    /**
     * 获得角色资源列表
     *
     * @param roleId
     * @return
     */
    List<Long> getRoleResIds(Long roleId);

    /**
     * 获得角色资源列表
     *
     * @param roleId
     * @return
     */
    Set<String> getRoleResIdentitys(Long roleId);

}
