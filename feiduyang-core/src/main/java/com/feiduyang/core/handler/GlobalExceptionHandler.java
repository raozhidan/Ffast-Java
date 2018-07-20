package com.feiduyang.core.handler;

import com.feiduyang.common.utils.ResultCode;
import com.feiduyang.common.vo.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({Exception.class, NullPointerException.class})
    @ResponseBody
    public ResponseInfo handleException(Exception e) {
        ResponseInfo result = new ResponseInfo(ResultCode.SERVICE_ERROR.getCode(), ResultCode.SERVICE_ERROR.getMessage());
        if (e != null) {
            result.addData("error", e.getMessage());
            e.printStackTrace();
        } else {
            logger.error("exception is null");
        }
        return result;
    }
}