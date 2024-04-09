package com.Lnn;

import com.Lnn.util.JwtClaimsConstant;
import com.Lnn.util.JwtProperties;
import com.Lnn.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtTest {
    @Autowired
    private JwtProperties jwtProperties;

    @Test
     public void tokenTest(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJlbXBJZCI6NSwiZXhwIjoxNzg0NjY5ODM2fQ.OKD7Ingr2fSWPp2vsdk083lcrsnA6_IzmbfcQHzFW3s";
        Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(), token);
        Integer userId = (Integer) claims.get(JwtClaimsConstant.EMP_ID);
        System.out.println(userId);
    }
}
