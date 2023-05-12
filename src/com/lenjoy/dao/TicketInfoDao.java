package com.lenjoy.dao;

import com.lenjoy.entity.TicketInfo;

import java.util.List;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/12 15:22
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public interface TicketInfoDao {
    List<TicketInfo> getTicketInfoListByBusinessId(Integer id);
}
