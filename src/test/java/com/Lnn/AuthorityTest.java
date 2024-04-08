package com.Lnn;

import com.Lnn.service.AuthorityService;
import com.Lnn.vo.responseVO.ClubAuthorityVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AuthorityTest {

    @Autowired
    private AuthorityService authorityService;
    @Test
    public void getAuthorityTest()
    {
        List<ClubAuthorityVO> lists = authorityService.getClubAuthorityByUserId(5);

        for(ClubAuthorityVO vo :lists)
        {
            System.out.println(vo);
        }

    }

}
