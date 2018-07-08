package com.feiduyang.pay.common.utils;

import com.feiduyang.core.aop.LogPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * 日志保存实现
 *
 * @author 45984（rao.zhidan@sccaptain.com.cn）
 * @create 2018/7/8
 */
@Component
public class LogPointImpl implements LogPoint {
    @Override
    public void saveLog(ProceedingJoinPoint joinPoint, String methodName, String operate) {

    }
}
