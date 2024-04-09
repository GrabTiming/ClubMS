package com.Lnn.DTO;

import lombok.Data;

@Data
public class ClubPageQueryDTO {
    //页码
    private int page;

    //每页记录数
    private int pageSize;

    //查询信息
    private String str;

    private String name;

    private String description;

    private String place;


}
