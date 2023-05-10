package com.lenjoy.utils;

import com.lenjoy.entity.MenuInfo;
import com.lenjoy.entity.SysUserInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * 模拟session
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/10 15:00
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public abstract class SessionUtil {
    public static MenuInfo menuInfo;
    public static SysUserInfo sysUserInfo;

    private static Map<String, Object> sessionMap = new HashMap<>();

    public static void setAttribute(String key, Object value) {
        sessionMap.put(key, value);
    }

    public static Object getAttribute(String key) {
        return sessionMap.get(key);
    }
}
