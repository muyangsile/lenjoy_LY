package com.lenjoy.dao;

import com.lenjoy.entity.SysUserInfo;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/10 16:04
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public interface SysUserInfoDao {
    /**
     * 根据账号密码获取系统用户对象
     * @param userName 用户名
     * @param password 密码
     * @return 系统用户对象
     */
    SysUserInfo getSysUserInfoByUserNameAndPassword(String userName,String password);
}
