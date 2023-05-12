package com.lenjoy.controller;

import com.lenjoy.service.TicketInfoService;
import com.lenjoy.service.impl.TicketInfoServiceImpl;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/12 15:23
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class TicketInfoController {

    private TicketInfoService ticketInfoService=new TicketInfoServiceImpl();
    public void showTicketList(){
        ticketInfoService.showTicketList();
    }

    public void addTicket(){
        ticketInfoService.addTicket();
    }
}
