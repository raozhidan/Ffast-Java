package com.feiduyang.common.constance;

/**
 * @ClassName CodeEnum
 * @Author Zhidan.Rao
 * @Date 2018年07月06日 15:26
 * @Version 1.0.0
 **/
public enum CodeEnum {
    SUCCESS("1", "成功！"),
    HAS_PAY("11", "订单已支付"),
    ERROR("-1", "服务器错误"),
    WECHAT_CODE_NULL("-2", "微信code码为空！");

    public String code;
    public String message;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    CodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
