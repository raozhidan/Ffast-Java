package com.feiduyang.common.support;

import com.baomidou.mybatisplus.plugins.Page;
import com.feiduyang.common.annotations.CrudConfig;
import com.feiduyang.common.annotations.Permission;
import com.feiduyang.common.utils.AnnotationUtils;
import com.feiduyang.common.vo.ResponseInfo;
import com.feiduyang.common.vo.ServiceRowsResult;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;

/**
 * @description: 基础增删改查控制器
 * @copyright:
 * @createTime: 2017/9/5 15:17
 * @author：dzy
 * @version：1.0
 */

public abstract class BaseCrudController<T extends BaseEntity, S extends ICrudService<T, ID>, ID> extends BaseController {

    /**
     * 初始化Controller
     */
    @PostConstruct
    private void initCrudController() {
        CrudConfig crudConfig = getCrudConfig();
        /**
         * 增删改查权限名自定义
         */
        if (crudConfig != null) {
            Method[] methods = getClass().getSuperclass().getMethods();
            for (int i = 0; i < methods.length; i++) {
                switch (methods[i].getName()) {
                    case "create":
                        if (!"create".equals(crudConfig.retrievePermission())) {
                            AnnotationUtils.setAnnotationValue(methods[i].getAnnotation(Permission.class), "value", crudConfig.createPermission());
                        }
                        break;
                    case "list":
                        if (!"list".equals(crudConfig.retrievePermission())) {
                            AnnotationUtils.setAnnotationValue(methods[i].getAnnotation(Permission.class), "value", crudConfig.retrievePermission());
                        }
                        break;
                    case "update":
                        if (!"update".equals(crudConfig.updatePermission())) {
                            AnnotationUtils.setAnnotationValue(methods[i].getAnnotation(Permission.class), "value", crudConfig.updatePermission());
                        }
                        break;
                    case "delete":
                        if (!"delete".equals(crudConfig.deletePermission())) {
                            AnnotationUtils.setAnnotationValue(methods[i].getAnnotation(Permission.class), "value", crudConfig.deletePermission());
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }


    /**
     * 查询
     *
     * @param m
     * @param page
     * @param simple 只查少数字段
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    @Permission(value = "list")
    public ServiceRowsResult list(T m, Integer pageSize, Integer page, Boolean simple, String sortField, String sortOrder) {
        ServiceRowsResult beforeResult = listBefore(m);
        if (beforeResult != null) {
            return beforeResult;
        }
        // 查询字段
        String[] properties = ((simple != null && simple) ? getSimpleProperties() : getProperties());
        Page<T> pageM = new Page<>();
        if (pageSize == null || page == null) {
            pageSize = 1000;
            page = 0;
        }
        // 排序相关
        if (sortOrder != null) {
            pageM.setAsc("asc".equals(sortOrder));
        } else {
            pageM.setAsc(isAsc());
        }
        if (sortField == null) {
            sortField = getSortField();
        }
        pageM.setOrderByField(sortField);
        pageM.setCurrent(page);
        pageM.setSize(pageSize);
        return getService().findListByPage(m, pageM);
    }

    /**
     * 增加
     *
     * @param m
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Permission(value = "create")
    public ResponseInfo create(T m) {
        m.setCreatorId(AuthCurrentUser.getUserId());
        ResponseInfo beforeResult = createBefore(m);
        if (beforeResult != null) {
            return beforeResult;
        }
        ResponseInfo result = getService().create(m);
        createAfter(m, result);
        return result;
    }

    /**
     * 更新
     *
     * @param m
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Permission(value = "update")
    public ResponseInfo update(T m) {
        m.setLastModifierId(AuthCurrentUser.getUserId());
        ResponseInfo beforeResult = updateBefore(m);
        if (beforeResult != null) {
            return beforeResult;
        }
        ResponseInfo result = getService().update(m, isUpdateAllColumn());
        updateAfter(m, result);
        return result;
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Permission(value = "delete")
    public ResponseInfo delete(String ids) {
        ResponseInfo beforeResult = deleteBefore(ids);
        if (beforeResult != null) {
            return beforeResult;
        }
        ResponseInfo result = getService().delete(ids);
        deleteAfter(ids, result);
        return result;
    }

    /**
     * 获得服务层 供子类覆盖
     *
     * @return
     */
    protected abstract S getService();

    @Override
    protected abstract Logger getLogger();

    private String[] getProperties() {
        CrudConfig crudConfig = getCrudConfig();
        if (crudConfig != null && crudConfig.properties().length > 0) {
            return crudConfig.properties();
        } else {
            return null;
        }
    }

    private String[] getSimpleProperties() {
        CrudConfig crudConfig = getCrudConfig();
        if (crudConfig != null && crudConfig.simpleProperties().length > 0) {
            return crudConfig.simpleProperties();
        } else {
            return null;
        }
    }


    /**
     * 以下方法可以再子类覆盖还实现自定义操作
     */

    /**
     * 创建前
     *
     * @param m
     * @return
     */
    protected ResponseInfo createBefore(T m) {
        return null;
    }

    /**
     * 删除前
     *
     * @param ids
     * @return
     */
    protected ResponseInfo deleteBefore(String ids) {
        return null;
    }

    /**
     * 更新前
     *
     * @param m
     * @return
     */
    protected ResponseInfo updateBefore(T m) {
        return null;
    }

    /**
     * 查询前
     *
     * @param m
     * @return
     */
    protected ServiceRowsResult listBefore(T m) {
        return null;
    }

    /**
     * 数据库数据插入后
     *
     * @param m
     * @param result
     */
    protected void createAfter(T m, ResponseInfo result) {
    }

    /**
     * 数据库数据删除后
     *
     * @param ids
     * @param result
     */
    protected void deleteAfter(String ids, ResponseInfo result) {
    }

    /**
     * 数据库数据更新后
     *
     * @param m
     * @param result
     */
    protected void updateAfter(T m, ResponseInfo result) {
    }

    /**
     * 数据库数据查询后
     *
     * @param m
     * @param result
     */
    protected void listAfter(T m, ResponseInfo result) {
    }


    /**
     * 从注解配置获得是否更新所有字段
     *
     * @return
     */
    private boolean isUpdateAllColumn() {
        CrudConfig crudConfig = getCrudConfig();
        if (crudConfig != null && crudConfig.updateAllColumn()) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 默认排序字段
     *
     * @return
     */
    private String getSortField() {
        CrudConfig crudConfig = getCrudConfig();
        if (crudConfig != null) {
            return crudConfig.sortField();
        }
        return null;
    }

    /**
     * 默认是否升序
     *
     * @return
     */
    private boolean isAsc() {
        CrudConfig crudConfig = getCrudConfig();
        if (crudConfig != null && crudConfig.isAsc()) {
            return true;
        }
        return false;
    }


    private CrudConfig getCrudConfig() {
        return getClass().getAnnotation(CrudConfig.class);
    }
}
