package com.Lnn.DTO;


import lombok.Data;

@Data
public class UserClubQueryDTO {

    private Integer id;
    //页码
    private int page;

    //每页记录数
    private int pageSize;

}