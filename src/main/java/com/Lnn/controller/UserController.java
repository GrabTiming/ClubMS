package com.Lnn.controller;

import com.Lnn.entity.RestBean;
import com.Lnn.entity.User;
import com.Lnn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/all")
    public RestBean<List<User>> getAll()
    {
        return RestBean.success(userMapper.getAllUser());
    }

}
