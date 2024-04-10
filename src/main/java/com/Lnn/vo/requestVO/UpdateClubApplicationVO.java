package com.Lnn.vo.requestVO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClubApplicationVO {

    private Integer userId;

    private String clubName;

    private Integer state;

}
