package com.lenjoy.service.impl;

import com.lenjoy.dao.SysUserInfoDao;
import com.lenjoy.dao.impl.SysUserInfoDaoImpl;
import com.lenjoy.entity.MenuInfo;
import com.lenjoy.entity.SysUserInfo;
import com.lenjoy.service.MenuInfoService;
import com.lenjoy.service.SystemService;
import com.lenjoy.utils.MD5Utils;
import com.lenjoy.utils.SessionUtil;
import com.lenjoy.utils.TrendsSwitchUtil;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/10 15:18
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class SystemServiceImpl implements SystemService {
    private SysUserInfoDao sysUserInfoDao = new SysUserInfoDaoImpl();
    private MenuInfoService menuInfoService = new MenuInfoServiceImpl();

    @Override
    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("==乐享洛阳-后台管理系统-->登录===================================");
        boolean flag = true;
        int errNum = 0;
        while (flag) {
            System.out.print("请输入用户名：");
            String userName = input.next();
            System.out.print("请输入密码：");
            String password = input.next();
            //密码加密（加密规则：密码先加密一次 然后把用户名作为盐 再对加密后的密码做一次加密）
            SysUserInfo sysUserInfo = sysUserInfoDao.getSysUserInfoByUserNameAndPassword(userName, MD5Utils.encryptMD5(password,userName));
            if (sysUserInfo != null) {
                flag = false;
                SessionUtil.sysUserInfo = sysUserInfo;
                System.out.println("\n登录成功，欢迎您：" + sysUserInfo.getName());
                //登录成功之后，展示登录之后的系统菜单
                menuInfoService.showMenu(SessionUtil.menuInfo.getId());
                //执行选定菜单对应的方法
                TrendsSwitchUtil.invokeMethod();
            } else {
                errNum++;
                System.out.println("当前错误次数" + errNum + "次，错误次数到达3次，退出系统！");
                if (errNum > 3) {
                    System.out.println("感谢您的使用！期待下次光临。");
                    System.exit(0);
                }
                System.out.println("账号或密码错误，请重新输入！");
            }
        }
    }

    @Override
    public void menuSettings() {
        menuInfoService.showMenu(SessionUtil.menuInfo.getId());
        TrendsSwitchUtil.invokeMethod();
    }
}
