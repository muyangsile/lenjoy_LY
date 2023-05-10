package com.lenjoy.controller;

import com.lenjoy.service.MenuInfoService;
import com.lenjoy.service.impl.MenuInfoServiceImpl;
import com.lenjoy.utils.SessionUtil;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/9 17:24
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class MenuInfoController {
    private MenuInfoService menuInfoService=new MenuInfoServiceImpl();
    /**
     * 显示主菜单
     */
    public void showMainMenu(){
        //展示主菜单
        menuInfoService.showMainMenu();
    }

    public void addMenu(){
        System.out.println("\n====乐享洛阳-后台管理系统:添加菜单("+ SessionUtil.sysUserInfo.getName()+")===============");
        menuInfoService.addMenu();
    }
}
