package com.lenjoy.service.impl;

import com.lenjoy.dao.BusinessInfoDao;
import com.lenjoy.dao.impl.BusinessInfoDaoImpl;
import com.lenjoy.entity.BusinessInfo;
import com.lenjoy.service.BusinessInfoService;
import com.lenjoy.service.MenuInfoService;
import com.lenjoy.utils.MD5Utils;
import com.lenjoy.utils.SessionUtil;
import com.lenjoy.utils.TrendsSwitchUtil;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/11 17:03
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class BusinessInfoServiceImpl implements BusinessInfoService {
    private BusinessInfoDao businessInfoDao = new BusinessInfoDaoImpl();

    @Override
    public void settleIn() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n===================商家入驻====================");
        System.out.print("请输入店铺名：");
        String name = input.next();
        System.out.print("请输入账号：");
        String userName = input.next();
        System.out.print("请输入密码：");
        String password = input.next();
        System.out.print("请输入联系人姓名：");
        String lxrName = input.next();
        System.out.print("请输入联系方式：");
        String tel = input.next();
        System.out.print("请输入店铺位置：");
        String address = input.next();
        //构建BusinessInfo对象
        BusinessInfo businessInfo = new BusinessInfo();
        businessInfo.setName(name);
        businessInfo.setUserName(userName);
        //密码加密
        businessInfo.setPassword(MD5Utils.encryptMD5(password, userName));
        businessInfo.setLxrName(lxrName);
        businessInfo.setTel(tel);
        businessInfo.setAddress(address);
        int rows = businessInfoDao.addBusinessInfo(businessInfo);
        System.out.println(rows > 0 ? "恭喜您，入驻成功！^_^，请登录" : "抱歉！入驻失败 -_-!");
        TrendsSwitchUtil.rollbackMethod();
    }

    @Override
    public void showMenu() {
        MenuInfoService menuInfoService = new MenuInfoServiceImpl();
        menuInfoService.showMenu(SessionUtil.menuInfo.getId());
        TrendsSwitchUtil.invokeMethod();
    }
}
