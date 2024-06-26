package com.Lnn.vo.requestVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubCreateVO {

    private Integer userId;//创建人Id

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
