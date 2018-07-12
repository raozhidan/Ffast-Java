package com.feiduyang.common.support;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.feiduyang.common.vo.ResponseInfo;
import com.feiduyang.common.vo.ServiceRowsResult;

import java.util.List;

/**
 * @description: 基础增删改查
 * @copyright:
 * @createTime: 2017/9/5 9:39
 * @author：dzy
 * @version：1.0
 */
public interface ICrudService<T extends BaseEntity, ID> extends IService<T> {
    /**
     * @param m 实体类
     * @return
     * @description: 插入对象
     * @createTime: 2017-9-5 10:00
     * @author: dzy
     */
    ResponseInfo create(T m);

    /**
     * @param m               实体类
     * @param updateAllColumn 是否更新所有字段
     * @return
     * @description: 更新对象
     * @createTime: 2017-9-5 10:00
     * @author: dzy
     */
    ResponseInfo update(T m, boolean updateAllColumn);

    /**
     * @param ids
     * @return
     * @description: 批量删除
     * @createTime: 2017-9-5 10:00
     * @author: dzy
     */
    ResponseInfo mulDelete(String ids);

    /**
     * @param id
     * @return
     * @description: 根据Id删除对象
     * @createTime: 2017-9-5 10:00
     * @author: dzy
     */
    ResponseInfo delById(ID id);

    /**
     * @param ids
     * @return
     * @description: 删除支持批量
     * @createTime: 2017-9-5 10:00
     * @author: dzy
     */
    ResponseInfo delete(String ids);

    /**
     * @param id
     * @return
     * @description: 根据Id发现对象
     * @createTime: 2017-9-5 10:00
     * @author: dzy
     */
    T findById(ID id);

    /**
     * @param m
     * @param page
     * @description: 分页查询
     * @createTime: 2017-9-5 10:00
     * @author: dzy
     */
    ServiceRowsResult findListByPage(T m, Page<T> page);

    /**
     * @param m
     * @param page
     * @description: 分页查询
     * @createTime: 2017-9-5 10:00
     * @author: dzy
     */
    ServiceRowsResult findListByPage(T m, Page<T> page, String[] properties);

    /**
     * @param m
     * @param properties 查询字段
     * @return
     * @description: 查询
     * @createTime: 2017-9-5 10:00
     * @author: dzy
     */
    ServiceRowsResult list(T m, String[] properties);

    /**
     * @param m
     * @param properties 查询字段
     * @return
     * @description: 查询
     * @createTime: 2017-9-5 10:00
     * @author: dzy
     */
    List<T> selectList(T m, String[] properties);

}
