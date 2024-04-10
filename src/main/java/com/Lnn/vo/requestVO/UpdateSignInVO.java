package com.Lnn.vo.requestVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSignInVO {


    private Integer userId;

    private Integer clubId;

    private Integer state;

}
