package com.feiduyang.web.controller.work;


import com.feiduyang.common.annotations.CrudConfig;
import com.feiduyang.common.annotations.Logined;
import com.feiduyang.core.support.BaseCrudController;
import com.feiduyang.web.entity.work.Backlog;
import com.feiduyang.web.service.work.IBacklogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description: 待办事项数据接口
 * @copyright:
 * @createTime: 2018-06-09 11:20:16
 * @author: dzy
 * @version: 1.0
 */
@Controller
@RequestMapping("/api/work/backlog")
@CrudConfig(sortField = "start_time", isAsc = true)
@Logined
public class BacklogController extends BaseCrudController<Backlog, IBacklogService, Long> {

    private static Logger logger = LoggerFactory.getLogger(BacklogController.class);

    @Resource
    private IBacklogService service;

    @Override
    protected IBacklogService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
