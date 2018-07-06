package com.feiduyang.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.feiduyang.common.constants.CodeEnum;

import java.io.Serializable;

/**
 * 执行的结果
 */
public class ResponseInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 返回的信息
     */
    protected String message;
    /**
     * 执行是否成功
     */
    protected Boolean success;

    protected Integer errNo;

    protected T data;

    protected String code;

    public static ResponseInfo createSuccess() {
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setCode(CodeEnum.SUCCESS.code);
        responseInfo.setMessage(CodeEnum.SUCCESS.message);
        return responseInfo;
    }

    public static <T> ResponseInfo<T> createSuccess(T data) {
        return createSuccess().setData(data);
    }

    public static ResponseInfo createCodeEnum(CodeEnum codeEnum) {
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setCode(codeEnum.code);
        responseInfo.setMessage(codeEnum.message);
        return responseInfo;
    }

    public static <T> ResponseInfo<T> createCodeEnum(CodeEnum codeEnum, T data) {
        return createCodeEnum(codeEnum).setData(data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResponseInfo() {
    }

    public ResponseInfo(Boolean success) {
        this.success = success;
    }

    public ResponseInfo(Integer errNo, String message) {
        this.errNo = errNo;
        this.message = message;
        this.success = false;
    }

    public ResponseInfo(CodeEnum codeEnum) {
        this.code = codeEnum.code;
        this.message = codeEnum.message;
    }

    public String toJSON() {
        JSONObject result = new JSONObject();
        result.put("message", message);
        result.put("success", success);
        result.put("data", data);
        result.put("errNo", errNo);
        return result.toString();
    }


    public ResponseInfo setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public ResponseInfo setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public Integer getErrNo() {
        return errNo;
    }

    public ResponseInfo setErrNo(Integer errNo) {
        this.errNo = errNo;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseInfo setData(T data) {
        this.data = data;
        return this;
    }
}
