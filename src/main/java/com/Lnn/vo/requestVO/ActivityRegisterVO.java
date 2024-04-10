package com.Lnn.vo.requestVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 对 活动报名 审核 的前端VO数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRegisterVO {

    private Integer userId;

    private String username;

    private String activityName;

    //将要设置的状态
    private Integer state;

}
