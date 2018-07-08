package com.feiduyang.pay.web.service.sys;

import com.feiduyang.core.support.ICrudService;
import com.feiduyang.core.vo.ResponseInfo;
import com.feiduyang.pay.web.entity.sys.User;


/**
 * @description: 系统_用户服务类
 * @copyright:
 * @createTime: 2017年08月31日 09:49:42
 * @author: dzy
 * @version: 1.0
 */
public interface IUserService extends ICrudService<User, Long> {
    /**
     * 根据username取得用户对象
     */
    User getUserByUserName(String username);

    /**
     * 验证用户
     */
    User verifyUser(String username, String password);

    /**
     * 重置密码
     */
    ResponseInfo reseting(Long ids);

    /**
     * 修改密码
     */
    ResponseInfo respwd(Long userId, String pwd, String newpwd, String newpwd2);

    /**
     * 根据登录结果更新登录次数时间信息
     */
    void updateLoginResult(String username, Boolean bool);

}
