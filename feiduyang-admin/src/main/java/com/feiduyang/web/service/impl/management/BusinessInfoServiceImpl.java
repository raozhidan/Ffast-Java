package com.feiduyang.web.service.impl.management;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.feiduyang.common.utils.Md5Utils;
import com.feiduyang.common.utils.PasswordUtil;
import com.feiduyang.common.utils.PinyinUtil;
import com.feiduyang.common.vo.ResponseInfo;
import com.feiduyang.common.vo.ServiceRowsResult;
import com.feiduyang.core.support.CrudServiceImpl;
import com.feiduyang.web.dao.management.BusinessInfoMapper;
import com.feiduyang.web.entity.management.BusinessInfo;
import com.feiduyang.web.entity.management.ChannelInfo;
import com.feiduyang.web.entity.sys.Role;
import com.feiduyang.web.entity.sys.User;
import com.feiduyang.web.entity.sys.UserRole;
import com.feiduyang.web.service.management.IBusinessInfoService;
import com.feiduyang.web.service.management.IChannelInfoService;
import com.feiduyang.web.service.sys.IRoleService;
import com.feiduyang.web.service.sys.IUserRoleService;
import com.feiduyang.web.service.sys.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 商户信息服务实现类
 * @copyright: ${copyright} (c)2018
 * @createTime: 2018-06-19 18:00:01
 * @author: zhidan.rao
 * @version: 1.0
 */
@Service
public class BusinessInfoServiceImpl extends CrudServiceImpl<BusinessInfoMapper, BusinessInfo, Long> implements IBusinessInfoService {

    @Autowired
    IChannelInfoService channelInfoService;

    @Value(value = "${auth.pwdDefault}")
    private String PWD_DEFAULT;

    @Value("${business.roleDefault}")
    private String ROLE_DEFAULT;

    @Autowired
    IUserService userService;

    @Autowired
    IRoleService roleService;

    @Autowired
    IUserRoleService userRoleService;

    @Override
    protected ResponseInfo createAfter(BusinessInfo m) {
        //创建成功之后初始化该商户的账户信息
        User user = new User();
        user.setName(m.getBusinessName());
        user.setSalt(Md5Utils.hash(Md5Utils.getUUID()));
        user.setPwd(PasswordUtil.getPwd(user.getSalt(), PWD_DEFAULT));
        user.setUsername(PinyinUtil.getInstance().getStringInitial(m.getBusinessName()));
        user.setTel(m.getBusinessPhone());
        user.setEmail(m.getBusinessEmail());
        user.setIsLock(0);
        user.setStatus(1);
        userService.create(user);

        EntityWrapper<Role> roleEntityWrapper = new EntityWrapper<>();
        roleEntityWrapper.eq("name", ROLE_DEFAULT);
        Role role = roleService.selectOne(roleEntityWrapper);
        if (role == null) {
            throw new RuntimeException("未定义商户默认账户的角色值！");
        }
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(role.getId());
        userRoleService.create(userRole);
        return super.createAfter(m);
    }


    @Override
    protected ServiceRowsResult listBefore(BusinessInfo m, EntityWrapper<BusinessInfo> ew) {
        return super.listBefore(m, ew);
    }

    @Override
    protected ServiceRowsResult listAfter(BusinessInfo m, List<BusinessInfo> resultList) {
        if (!resultList.isEmpty()) {
            for (BusinessInfo businessInfo : resultList) {
                ChannelInfo channelInfo = channelInfoService.findById(businessInfo.getBusinessChannelId());
                if (channelInfo != null) {
                    businessInfo.setBusinessChannelName(channelInfo.getChannelName());
                }
            }
        }
        return super.listAfter(m, resultList);
    }
}
