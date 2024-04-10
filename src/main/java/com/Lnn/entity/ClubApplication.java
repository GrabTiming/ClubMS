package com.Lnn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Clubapplication)实体类
 *
 * @author makejava
 * @since 2024-04-10 08:11:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClubApplication {
   
    private Integer id;
    /**
     * 创建者
     */
    private Integer userId;
    /**
     * 社团名称
     */
    private String clubName;
    /**
     * 社团简介
     */
    private String description;
    /**
     * 社团地点
     */
    private String place;
    /**
     * 联系方式
     */
    private String email;

    /**
     * 审核状态
     */
    private Integer state;


}

