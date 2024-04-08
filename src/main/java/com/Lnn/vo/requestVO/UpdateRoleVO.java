package com.Lnn.vo.requestVO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoleVO {

    private Integer userId;

    private Integer clubId;

    private Integer role;

}
