package com.Lnn;

import com.Lnn.util.JwtClaimsConstant;
import com.Lnn.util.JwtProperties;
import com.Lnn.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtTest {

    @Autowired
    private JwtProperties jwtProperties;

    @Test
    public void tokenTest(){
        String token ="eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjowLCJ1c2VySWQiOjUsInVzZXJuYW1lIjoiTGp0IiwiZXhwIjoxNzg0NzE5MjgwfQ.XhsOvdnso8mbFeRp7TFOvkX_ssAXgnSg8OmPyuQXjB0";
        Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(),token);
        Integer userId = (Integer) claims.get(JwtClaimsConstant.USER_ID);
        System.out.println(userId);
    }

}
