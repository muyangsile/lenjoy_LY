package com.lenjoy.utils;

import com.lenjoy.controller.MenuInfoController;
import com.lenjoy.dao.MenuInfoDao;
import com.lenjoy.dao.impl.MenuInfoDaoImpl;
import com.lenjoy.entity.MenuInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description:
 *  实现菜单的动态选择
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/10 14:19
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class TrendsSwitchUtil {

    private static final String PREFIX="com.lenjoy.controller.";
    /**
     * 执行选择菜单对应的方法
     */
    public static void invokeMethod(){
        //从菜单对象中获取url，方便是实例化对象 执行方法
        //先根据 “/” 把url这个字符串拆开  下标为0的是类名  下标为1的是方法名
        String[] split = SessionUtil.menuInfo.getUrl().split("/");
        try {
            //在类型前拼上"com.lenjoy.controller"，通过反射实例化对象
            Class aClass = Class.forName(PREFIX + split[0]);
            //通过反射创建对象
            Object obj = aClass.newInstance();
            //根据方法名获取对应的执行方法
            Method method = aClass.getMethod(split[1]);
            //执行方法
            method.invoke(obj);
        } catch (ClassNotFoundException e) {
            System.err.println("获取字节码对象失败！--->"+(PREFIX + split[0]));
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("实例化对象失败");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.err.println("未找到执行方法");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.err.println("执行方法失败");
            e.printStackTrace();
        }
    }

    /**
     * 统一的返回上一级菜单
     */
    public static void rollbackMethod(){
        //获取当前选中菜单的父级ID
        Integer pId = SessionUtil.menuInfo.getPId();
        if (pId!=-1){
            MenuInfoDao dao=new MenuInfoDaoImpl();
            SessionUtil.menuInfo=dao.getMenuInfoById(pId);
            invokeMethod();
        }else {
            //直接调用主菜单的方法
            MenuInfoController menuInfoController=new MenuInfoController();
            menuInfoController.showMainMenu();
        }

    }
}
