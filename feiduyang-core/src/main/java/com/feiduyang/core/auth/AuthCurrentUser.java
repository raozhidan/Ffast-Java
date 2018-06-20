package com.feiduyang.core.auth;

/**
 * 当前登陆用户
 *
 * @author zhidan.rao
 * @create 2018/6/19
 */
public class AuthCurrentUser {

    private final static ThreadLocal<OperatorBase> userLocal = new ThreadLocal<>();

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
