package com.feiduyang.pay.common.utils;

import com.feiduyang.common.aop.LogPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @ClassName LogPointImpl
 * @Author Zhidan.Rao
 * @Date 2018年07月09日 13:39
 * @Version 1.0.0
 **/
@Component
public class LogPointImpl implements LogPoint {
    @Override
    public void saveLog(ProceedingJoinPoint joinPoint, String methodName, String operate) {

    }
}
