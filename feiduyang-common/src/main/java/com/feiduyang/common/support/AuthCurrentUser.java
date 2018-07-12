package com.feiduyang.common.support;

/**
 * 当前登陆用户
 *
 * @author zhidan.rao
 * @create 2018/6/19
 */
public class AuthCurrentUser {

    private final static ThreadLocal<OperatorBase> userLocal = new ThreadLocal<>();
    private final static ThreadLocal<String> userCode = new ThreadLocal<>();

    public static String getUserCode() {
        return userCode.get();
    }

    public static void setUserCode(String code) {
        userCode.set(code);
    }

    public static OperatorBase getUser() {
        return userLocal.get();
    }

    public static void setUser(OperatorBase user) {
        userLocal.set(user);
    }

    public static Long getUserId() {
        return userLocal.get().getUserId();
    }

    public static void removeUser() {
        userLocal.remove();
    }
}
