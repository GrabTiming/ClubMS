package com.Lnn.vo.requestVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubApplicationCreateVO {

    private Integer userid;
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

}
