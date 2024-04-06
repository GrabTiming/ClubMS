package com.Lnn.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Activity) 活动表
 *
 * @author makejava
 * @since 2024-04-06 18:52:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity  {
   
    private Integer id;
    /**
     * 所属社团id
     */
    private Integer clubId;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 活动描述
     */
    private String description;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;


}

