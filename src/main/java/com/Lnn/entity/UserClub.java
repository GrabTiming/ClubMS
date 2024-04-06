package com.Lnn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (UserClub) 用户-社团表
 *
 * @author makejava
 * @since 2024-04-06 18:53:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserClub  {
   
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 社团id
     */
    private Integer clubId;
    /**
     * 权限(二进制表示，0位查看成员信息，1位审核成员申请，2位活动全权管理)
     */
    private String authority;
    /**
     * 0社员，1社长
     */
    private Integer role;
    /**
     * (0未审核，1未通过，2通过)
     */
    private String state;


}

