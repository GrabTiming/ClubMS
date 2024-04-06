package com.Lnn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Attendance) 签到表
 *
 * @author makejava
 * @since 2024-04-06 18:52:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance  {
   
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
     * 签到状态
     */
    private String state;


}

