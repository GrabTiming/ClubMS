package com.Lnn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2024-04-06 18:52:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentVO {

    /**
     * 用户id
     */
    private String username;
    /**
     * 活动id
     */
    private String activityName;
    /**
     * 缴费金额
     */
    private Double cost;


}

