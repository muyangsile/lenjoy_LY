package com.lenjoy.controller;

import com.lenjoy.service.BusinessInfoService;
import com.lenjoy.service.impl.BusinessInfoServiceImpl;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/11 17:03
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class BusinessInfoController {

    private BusinessInfoService businessInfoService=new BusinessInfoServiceImpl();


    public void showMenu(){
        businessInfoService.showMenu();
    }


    /**
     * 商家入驻
     */
    public void settleIn(){
        businessInfoService.settleIn();
    }
}
