package com.lenjoy.dao.impl;

import com.lenjoy.dao.TicketInfoDao;
import com.lenjoy.entity.TicketInfo;
import com.lenjoy.utils.BaseDao;

import java.util.List;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/12 15:22
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class TicketInfoDaoImpl extends BaseDao<TicketInfo> implements TicketInfoDao {
    @Override
    public List<TicketInfo> getTicketInfoListByBusinessId(Integer id) {
        return selectListForObject("select * from t_ticket_info where bus_id=?", TicketInfo.class, id);
    }

    @Override
    public int addTicketInfo(TicketInfo ticketInfo) {
        String sql = "insert into t_ticket_info values(null,?,?,?,?,?,?,?,?,?,now(),?,default)";
        return executeUpdate(sql,
                ticketInfo.getTitle(),
                ticketInfo.getBusId(),
                ticketInfo.getType(),
                ticketInfo.getDiKou(),
                ticketInfo.getZheKou(),
                ticketInfo.getMan(),
                ticketInfo.getJian(),
                ticketInfo.getMoney(),
                ticketInfo.getRemark(),
                ticketInfo.getCreateUser()
        );
    }
}
