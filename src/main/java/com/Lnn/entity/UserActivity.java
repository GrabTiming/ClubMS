package com.Lnn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (UserActivity) 用户-活动表
 *
 * @author makejava
 * @since 2024-04-06 18:53:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserActivity  {
   
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 活动id
     */
    private Integer activityId;
    /**
     * 报名状态(0未审核，1未通过，2已通过)
     */
    private String state;


}

