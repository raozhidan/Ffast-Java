package com.feiduyang.core.handler;


import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.feiduyang.core.auth.AuthCurrentUser;
import com.feiduyang.core.utils.DateUtil;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @description: mybatis plus公共字段填充处理器
 * @copyright:
 * @createTime: 2017/7/17 10:58
 * @author：dzy
 * @version：1.0
 */

public class BaseEntityHandler extends MetaObjectHandler {

    /**
     * 测试 user 表 name 字段为空自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 更多查看源码测试用例
        //System.out.println("insert fill");
        //mybatis-plus版本2.0.9+
        setFieldValByName("createTime", DateUtil.getNowTimestampStr(), metaObject);
        setFieldValByName("lastModifyTime", DateUtil.getNowTimestampStr(), metaObject);
        if (AuthCurrentUser.getUser() != null) {
            setFieldValByName("creatorId", AuthCurrentUser.getUserId(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //更新填充
        //System.out.println("update fill");
        //mybatis-plus版本2.0.9+
        setFieldValByName("lastModifyTime", DateUtil.getNowTimestampStr(), metaObject);
        if (AuthCurrentUser.getUser() != null) {
            setFieldValByName("lastModifierId", AuthCurrentUser.getUserId(), metaObject);
        }
    }
}