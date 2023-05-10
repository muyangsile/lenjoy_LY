package com.lenjoy;

import com.lenjoy.controller.MenuInfoController;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/9 17:13
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class DoMain {
    //这是一个main方法，这是程序的入口
    public static void main(String[] args) {
        MenuInfoController menuInfoController=new MenuInfoController();
        menuInfoController.showMainMenu();
    }
}
