package com.Lnn.vo.responseVO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignStateVO {

    private Integer userId;

    private String username;


    private Integer clubId;

    private String clubName;

    private Integer state;

}
