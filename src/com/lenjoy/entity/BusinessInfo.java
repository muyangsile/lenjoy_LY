package com.lenjoy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/11 16:57
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessInfo {
    private Integer id;
    private String name;
    private String userName;
    private String password;
    private String lxrName;
    private String tel;
    private String address;
    private Integer jobType;
    private Date createTime;
    private Double score;
    private Integer status;
}
