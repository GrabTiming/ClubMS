package com.Lnn.vo.responseVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubAuthorityVO {

    private String username;
    //社团名称
    private String clubName;
    //在这个社团的权限
    private Integer authority;
    //
    private Integer role;

}
