package com.feiduyang.web.controller.sys;

import com.feiduyang.core.annotations.CrudConfig;
import com.feiduyang.core.annotations.Logined;
import com.feiduyang.core.annotations.Permission;
import com.feiduyang.core.support.BaseCrudController;
import com.feiduyang.core.vo.ResponseInfo;
import com.feiduyang.web.entity.sys.Res;
import com.feiduyang.web.service.sys.IResService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description: 系统_资源数据接口
 * @copyright:
 * @createTime: 2017-09-13 09:14:49
 * @author: dzy
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/sys/res")
@CrudConfig(updateAllColumn = true, retrievePermission = "")
@Permission(value = "res")
@Logined
public class ResController extends BaseCrudController<Res, IResService, Long> {

    private static Logger logger = LoggerFactory.getLogger(ResController.class);

    @Resource
    private IResService service;

    @Override
    protected IResService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


    @Override
    protected ResponseInfo createBefore(Res m) {
        return null;
    }

    @Override
    protected ResponseInfo deleteBefore(String ids) {
        return null;
    }

    @Override
    protected ResponseInfo updateBefore(Res m) {
        return null;
    }

    @Override
    protected void createAfter(Res m, ResponseInfo result) {
        if ("true".equals(getRequestParamString("addBaseCrud")) && m.getResType() == 1) {
            service.addBaseCrud(m);
        }
    }
}
