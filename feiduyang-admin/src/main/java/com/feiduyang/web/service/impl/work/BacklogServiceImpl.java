package com.feiduyang.web.service.impl.work;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.feiduyang.common.vo.ResponseInfo;
import com.feiduyang.common.vo.ServiceRowsResult;
import com.feiduyang.core.support.CrudServiceImpl;
import com.feiduyang.web.dao.work.BacklogMapper;
import com.feiduyang.web.entity.work.Backlog;
import com.feiduyang.web.service.work.IBacklogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @description: 待办事项服务实现类
 * @copyright:
 * @createTime: 2018-06-09 11:20:16
 * @author: dzy
 * @version: 1.0
 */
@Service
public class BacklogServiceImpl extends CrudServiceImpl<BacklogMapper, Backlog, Long> implements IBacklogService {

    @Override
    protected ResponseInfo createBefore(Backlog m) {
        m.setUserIds(getLoginUserId().toString());
        return null;
    }


    @Override
    protected ServiceRowsResult listBefore(Backlog m, EntityWrapper<Backlog> ew) {
        m.setUserIds(getLoginUserId().toString());
        if (StringUtils.isNotBlank(m.getAfterDate())) {
            ew.where("unix_timestamp(start_time) >= unix_timestamp({0})", m.getAfterDate());
            m.setAfterDate(null);
        }
        return null;
    }
}
