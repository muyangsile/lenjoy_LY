package com.lenjoy.controller;

import com.lenjoy.service.MenuInfoService;
import com.lenjoy.service.SystemService;
import com.lenjoy.service.impl.MenuInfoServiceImpl;
import com.lenjoy.service.impl.SystemServiceImpl;
import com.lenjoy.utils.SessionUtil;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/10 14:24
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class SystemController {
    private SystemService systemService =new SystemServiceImpl();
    public void showMenu(){
        System.out.println("================乐享洛阳-后台管理系统===============");
        systemService.login();
    }

    public void menuSettings(){
        System.out.println("\n====乐享洛阳-后台管理系统("+SessionUtil.sysUserInfo.getName()+")===============");
        systemService.menuSettings();
    }

}
