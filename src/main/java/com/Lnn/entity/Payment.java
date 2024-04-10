package com.Lnn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Integer userId;

    private Integer activityId;

    private Double cost;

    private Integer state;

}
