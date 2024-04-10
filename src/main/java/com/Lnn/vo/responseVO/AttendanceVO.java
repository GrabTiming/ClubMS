package com.Lnn.vo.responseVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceVO {

    private Integer userId;

    private String username;

    private Integer activityId;

    private String activityName;
    /**
     * 签到状态
     */
    private Integer state;

}
