package com.lenjoy.service.impl;

import com.lenjoy.dao.TicketInfoDao;
import com.lenjoy.dao.impl.TicketInfoDaoImpl;
import com.lenjoy.entity.BusinessInfo;
import com.lenjoy.entity.TicketInfo;
import com.lenjoy.service.MenuInfoService;
import com.lenjoy.service.TicketInfoService;
import com.lenjoy.utils.SessionUtil;
import com.lenjoy.utils.TrendsSwitchUtil;

import java.util.List;


/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/12 15:23
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class TicketInfoServiceImpl implements TicketInfoService {
    private TicketInfoDao ticketInfoDao = new TicketInfoDaoImpl();

    @Override
    public void showTicketList() {
        BusinessInfo businessInfo = (BusinessInfo) SessionUtil.getAttribute("businessInfo");
        List<TicketInfo> ticketInfos = ticketInfoDao.getTicketInfoListByBusinessId(businessInfo.getId());
        showTickets(ticketInfos);
        MenuInfoService menuInfoService=new MenuInfoServiceImpl();
        menuInfoService.showMenu(SessionUtil.menuInfo.getId());
        TrendsSwitchUtil.invokeMethod();
    }

    @Override
    public void addTicket() {
        System.out.println("");
    }

    private void showTickets(List<TicketInfo> ticketInfos) {
        System.out.println("|-编号-----优惠券名-------------价格-------------说明------------------------");
        if (ticketInfos != null && ticketInfos.size() > 0) {
            for (int i = 0; i < ticketInfos.size(); i++) {
                TicketInfo ticketInfo = ticketInfos.get(i);
                System.out.println("|-" + (i + 1) + "\t" + ticketInfo.getTitle() + "\t" + ticketInfo.getMoney() + "/元");
                System.out.println("|-\t" + ticketInfo.getRemark());
                System.out.println("---------------------------------------------------------");
            }
        }else {
            System.out.println("\n\t\t---------暂无数据-----------");
        }
    }
}
