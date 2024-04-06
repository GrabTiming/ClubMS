package com.Lnn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Club)社团表
 *
 * @author makejava
 * @since 2024-04-06 18:52:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Club  {
   
    private Integer id;
    /**
     * 社团名称
     */
    private String name;
    /**
     * 社团简介
     */
    private String description;
    /**
     * 联系方式
     */
    private String email;
    /**
     * 活动地点
     */
    private String place;


}

