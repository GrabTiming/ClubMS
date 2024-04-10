package com.Lnn.vo.responseVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentVO {

    private Integer userId;

    private String username;

    private Integer activityId;

    private String activityName;

    private Double cost;

    private Integer state;

}
