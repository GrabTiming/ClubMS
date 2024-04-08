package com.Lnn;

import com.Lnn.entity.User;
import com.Lnn.mapper.UserMapper;
import com.Lnn.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test()
    {
        List<User> users = userMapper.getAllUser();
        System.out.println(users.toString());
    }
}
