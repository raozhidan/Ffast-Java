package com.feiduyang.web.service.impl.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.feiduyang.common.aop.LogPoint;
import com.feiduyang.common.utils.IpUtils;
import com.feiduyang.common.vo.ServiceRowsResult;
import com.feiduyang.core.support.CrudServiceImpl;
import com.feiduyang.web.dao.sys.LogMapper;
import com.feiduyang.web.entity.sys.Log;
import com.feiduyang.web.service.sys.ILogService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @description: 操作日志表服务实现类
 * @copyright:
 * @createTime: 2017-11-14 14:48:11
 * @author: dzy
 * @version: 1.0
 */
@Service
public class LogServiceImpl extends CrudServiceImpl<LogMapper, Log, Long> implements ILogService, LogPoint {
    private static final String LOG_CONTENT = "[类名]:%s,[方法]:%s,[参数]:%s,[IP]:%s";

    @Override
    public void saveLog(ProceedingJoinPoint joinPoint, String methodName, String operate) {
        /**
         * 日志入库
         */
        Log log = new Log();
        log.setCreatorId(getLoginUserId());
        log.setContent(operateContent(joinPoint, methodName, getRequest()));
        log.setOperation(operate);
        baseMapper.insert(log);
    }

    /**
     * 拼接操作内容
     *
     * @param joinPoint
     * @param methodName
     * @param request
     * @return
     */
    public String operateContent(ProceedingJoinPoint joinPoint, String methodName, HttpServletRequest request) {
        String className = joinPoint.getTarget().getClass().getName();
        Object[] params = joinPoint.getArgs();
        StringBuffer bf = new StringBuffer();
        if (params != null && params.length > 0) {
            Enumeration<String> paraNames = request.getParameterNames();
            while (paraNames.hasMoreElements()) {
                String key = paraNames.nextElement();
                bf.append(key).append("=");
                bf.append(request.getParameter(key)).append("&");
            }
            if (StringUtils.isBlank(bf.toString())) {
                bf.append(request.getQueryString());
            }
        }
        return String.format(LOG_CONTENT, className, methodName, bf.toString(), IpUtils.getIpAddr(request));
    }

    @Override
    public ServiceRowsResult findListByPage(Log m, Page<Log> page, String[] properties) {
        ServiceRowsResult result = new ServiceRowsResult(false);
        page.setRecords(baseMapper.listByPage(page, m));
        result.setPage(page.getRecords(), page.getTotal());
        result.setSuccess(true);
        return result;
    }
}
