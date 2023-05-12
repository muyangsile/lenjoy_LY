package com.lenjoy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/12 15:18
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketInfo {
    private Integer id;
    private String title;
    private Integer busId;
    private Integer type;
    private Double diKou;
    private Double zheKou;
    private Double man;
    private Double jian;
    private Double money;
    private String remark;
    private Date createTime;
    private Integer createUser;
    private Integer status;
}
