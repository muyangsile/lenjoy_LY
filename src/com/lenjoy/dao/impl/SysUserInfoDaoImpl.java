package com.lenjoy.dao.impl;

import com.lenjoy.dao.SysUserInfoDao;
import com.lenjoy.entity.SysUserInfo;
import com.lenjoy.utils.BaseDao;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/10 16:05
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class SysUserInfoDaoImpl extends BaseDao<SysUserInfo> implements SysUserInfoDao {
    @Override
    public SysUserInfo getSysUserInfoByUserNameAndPassword(String userName, String password) {
        String sql = "select * from t_sys_user_info where user_name=? and `password`=?";
        return selectOne(sql, SysUserInfo.class, userName, password);
    }
}
