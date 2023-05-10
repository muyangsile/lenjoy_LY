package com.lenjoy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description:
 * 菜单类
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/9 17:27
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuInfo /*extends BaseEntity*/{
    //菜单编号 主键自增
    private Integer id;
    //菜单名称
    private String name;
    //菜单url
    private String url;
    //菜单小图标
    private String icon;
    //菜单等级
    private Integer level;
    //父级ID
    private Integer pId;
    //菜单类型  0 管理系统 1商家 2用户 3经销商 4经销商管理系统
    private Integer type;
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
