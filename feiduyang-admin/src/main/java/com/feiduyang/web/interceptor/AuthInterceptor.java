package com.feiduyang.web.interceptor;


import com.feiduyang.api.sys.IRoleResService;
import com.feiduyang.common.vo.Operator;
import com.feiduyang.core.interceptor.BaseAuthInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @description: 登录拦截器
 * @copyright:
 * @createTime: 2017/9/5 17:56
 * @author：dzy
 * @version：1.0
 */
public class AuthInterceptor extends BaseAuthInterceptor<Operator> {
    private static Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Resource
    IRoleResService roleResService;

    @Override
    protected Set<String> getRolePerms(Long roleId) {
        return roleResService.getRoleResIdentitys(roleId);
    }

}
