package com.lenjoy.entity;

import lombok.Data;

import java.util.Date;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/9 17:34
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
@Data
public class BaseEntity {
    //菜单编号 主键自增
    private Integer id;
    //创建时间
    private Date createTime;
    //创建人
    private Integer createUser;
    //修改时间
    private Date updateTime;
    //修改人
    private Integer updateUser;
    //状态
    private Integer status;
}
