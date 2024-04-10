package com.Lnn.vo.responseVO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询 社团创建 申请信息的显示数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubApplicationVO {

    private Integer userId;
    /**
     * 申请人姓名
     */
    private String username;
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

    private Integer state;

}
