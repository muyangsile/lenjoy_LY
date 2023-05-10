package com.lenjoy.service.impl;

import com.lenjoy.dao.MenuInfoDao;
import com.lenjoy.dao.impl.MenuInfoDaoImpl;
import com.lenjoy.entity.MenuInfo;
import com.lenjoy.service.MenuInfoService;
import com.lenjoy.utils.SessionUtil;
import com.lenjoy.utils.TrendsSwitchUtil;

import java.util.List;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/9 17:48
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class MenuInfoServiceImpl implements MenuInfoService {
    private MenuInfoDao menuInfoDao = new MenuInfoDaoImpl();

    @Override
    public void showMainMenu() {
        System.out.println("======================乐享洛阳======================");
        showMenu(-1);
        TrendsSwitchUtil.invokeMethod();
    }

    @Override
    public void showMenu(Integer pId) {
        Scanner input = new Scanner(System.in);
        //查询数据库，拿到一级菜单集合
        List<MenuInfo> menuInfoList = menuInfoDao.getMenuInfoListByPId(pId);
        //遍历菜单集合，生成菜单
        for (int i = 0; i < menuInfoList.size(); i++) {
            System.out.println("\t" + (i + 1) + ":" + menuInfoList.get(i).getName());
        }
        boolean flag = false;
        do {
            System.out.print("请选择菜单：");
            int menuId = input.nextInt();
            if (menuId > 0 && menuId <= menuInfoList.size()) {
                SessionUtil.menuInfo = menuInfoList.get(menuId - 1);
            } else {
                System.out.println("没有这个菜单，请重新选择");
                flag = true;
            }
        } while (flag);
    }

    @Override
    public void addMenu() {
        Scanner input = new Scanner(System.in);
        Integer pId = getMenuInfoPid();
        MenuInfo menuInfo = new MenuInfo();
        System.out.print("请输入菜单名称：");
        menuInfo.setName(input.next());
        System.out.print("请输入菜单URL：");
        menuInfo.setUrl(input.next());
        System.out.print("请输入菜单小图标：");
        menuInfo.setIcon(input.next());
        System.out.print("请输入菜单序号：");
        menuInfo.setLevel(input.nextInt());
        System.out.print("请输入菜单类型：");
        menuInfo.setType(input.nextInt());
        //TODO 暂时用控制台录入的方式添加
        System.out.print("请输入菜单PID：");
        menuInfo.setPId(input.nextInt());
        menuInfo.setCreateUser(SessionUtil.sysUserInfo.getId());
        menuInfo.setUpdateUser(SessionUtil.sysUserInfo.getId());
        int rows = menuInfoDao.addMenuInfo(menuInfo);
        System.out.println(rows > 0 ? "添加成功" : "添加失败");
    }

    private Integer getMenuInfoPid() {
        return null;
    }
}
