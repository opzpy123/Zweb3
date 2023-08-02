package com.opzpy123.zweb3.core.utils;

import com.opzpy123.zweb3.web.dto.ContextUserInfo;

public class AppContext {

    // 当前线程中用户信息
    private final static ThreadLocal<ContextUserInfo> CURRENT_USER = new InheritableThreadLocal<>();

    /**
     * 获取当前线程中用户信息
     *
     * @return 用户信息
     */
    public static ContextUserInfo getUserInfo() {
        return CURRENT_USER.get();
    }

    /**
     * 设置线程中用户信息
     *
     * @param userInfo 用户信息
     */
    public static void setUserInfo(ContextUserInfo userInfo) {
        CURRENT_USER.set(userInfo);
    }

    /**
     * 清除当前线程中用户信息
     */
    public static void cleanUser() {
        CURRENT_USER.remove();
    }

}
