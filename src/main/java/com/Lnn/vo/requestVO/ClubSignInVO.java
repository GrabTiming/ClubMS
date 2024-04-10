package com.Lnn.vo.requestVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubSignInVO {

    private Integer userId;

    private Integer clubId;

    private String username;

    private String clubName;

}
