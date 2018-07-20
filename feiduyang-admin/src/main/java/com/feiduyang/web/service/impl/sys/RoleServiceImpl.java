package com.feiduyang.web.service.impl.sys;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.feiduyang.api.sys.IRoleService;
import com.feiduyang.common.entity.sys.Role;
import com.feiduyang.common.support.CrudServiceImpl;
import com.feiduyang.common.vo.ResponseInfo;
import com.feiduyang.common.vo.ServiceRowsResult;
import com.feiduyang.web.dao.sys.RoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 系统_角色服务实现类
 * @copyright:
 * @createTime: 2017-09-12 17:18:46
 * @author: dzy
 * @version: 1.0
 */
@Service
public class RoleServiceImpl extends CrudServiceImpl<RoleMapper, Role, Long> implements IRoleService {

    @Override
    protected ServiceRowsResult listBefore(Role m, EntityWrapper<Role> ew) {
        if (m.getName() != null) {
            ew.like("name", m.getName());
            m.setName(null);
        }
        if (m.getDescription() != null) {
            ew.like("description", m.getDescription());
            m.setDescription(null);
        }
        if (m.getStatus() != null) {
            ew.eq("status", m.getStatus());
            m.setStatus(null);
        }
        return null;
    }

    @Override
    protected ResponseInfo createBefore(Role m) {
        ResponseInfo result = new ResponseInfo();
        EntityWrapper ew = new EntityWrapper<Role>();
        ew.eq("name", m.getName());
        if (selectCount(ew) > 0) {
            result.setMessage("该角色已存在");
            return result;
        } else {
            return null;
        }
    }

    @Override
    protected ResponseInfo deleteBefore(String ids, EntityWrapper<Role> ew) {
        EntityWrapper selectEw = new EntityWrapper<Role>();
        selectEw.in("id", ids);
        List<Role> roles = baseMapper.selectList(selectEw);
        for (Role role : roles) {
            if (new Integer(1).equals(role.getIsSys())) {
                return new ResponseInfo(false).setMessage("无法删除系统角色:" + role.getName());
            }
        }
        return null;
    }


    @Override
    protected ResponseInfo updateBefore(Role m, Role oldM) {
        if (Integer.valueOf(1).equals(oldM.getIsSys())) {
            return new ResponseInfo(false).setMessage("不能修改系统角色");
        }
        return null;
    }
}
