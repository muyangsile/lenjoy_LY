package com.lenjoy.service;

import com.lenjoy.entity.MenuInfo;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/9 17:48
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public interface MenuInfoService {
    void showMainMenu();
    void showMenu(Integer pId);

    void addMenu();
}
