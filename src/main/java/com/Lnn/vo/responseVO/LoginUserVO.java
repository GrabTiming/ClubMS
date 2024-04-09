package com.Lnn.vo.responseVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUserVO {

    private Integer id;

    private String username;

    private String password;

    private Integer role;

    private String token;

}
