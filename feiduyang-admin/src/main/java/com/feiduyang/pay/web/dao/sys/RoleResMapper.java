package com.feiduyang.pay.web.dao.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feiduyang.web.entity.sys.Res;
import com.feiduyang.web.entity.sys.RoleRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 系统_角色资源Mapper接口
 * @copyright:
 * @createTime: 2017年08月31日 09:49:42
 * @author: dzy
 * @version: 1.0
 */
public interface RoleResMapper extends BaseMapper<RoleRes> {
    /**
     * 根据角色id获得资源列表
     *
     * @param roleId
     * @param resType
     * @return
     */
    List<Res> listByRoleId(@Param("roleIds") String roleIds, @Param("resType") Integer resType);
}