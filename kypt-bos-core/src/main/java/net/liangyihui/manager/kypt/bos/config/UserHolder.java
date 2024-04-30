package net.liangyihui.manager.kypt.bos.config;


import net.liangyihui.manager.kypt.bos.bo.UserInfo;

/**
 * 存储用户信息
 *
 * @author liu_y
 */
public class UserHolder {

    public static ThreadLocal<UserInfo> userInfoBoThreadLocal = new ThreadLocal<>();

    public static void setUserInfo(UserInfo userInfo) {
        userInfoBoThreadLocal.remove();
        userInfoBoThreadLocal.set(userInfo);
    }

    public static UserInfo getUserInfo() {
        return userInfoBoThreadLocal.get();
    }

}
