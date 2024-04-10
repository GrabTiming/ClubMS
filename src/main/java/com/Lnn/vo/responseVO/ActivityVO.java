package com.Lnn.vo.responseVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*
  查询活动时，表现出来的数据
 */
public class ActivityVO {

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

    private Double cost;

    private Date endTime;

    private Integer state;

}
