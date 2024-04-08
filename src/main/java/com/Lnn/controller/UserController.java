package com.Lnn.controller;

import com.Lnn.result.RestBean;
import com.Lnn.entity.User;
import com.Lnn.mapper.UserMapper;
import com.Lnn.service.UserService;
import com.Lnn.vo.requestVO.UserRegisterVO;
import com.Lnn.vo.responseVO.LoginUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


//    @PostMapping("/register")
//    public RestBean<String> register(@RequestParam("username") String username,@RequestParam("password") String password)
//    {
//        return userService.register(username,password);
//    }

    @PostMapping("/register")
    public RestBean<User> register(@RequestBody UserRegisterVO userRegisterVO)
    {
        System.out.println(userRegisterVO);
        return userService.register(userRegisterVO.getUsername(),userRegisterVO.getPassword());
    }
    @PostMapping("/login")
    public RestBean<LoginUserVO> login(@RequestBody UserRegisterVO userRegisterVO)
    {
        System.out.println(userRegisterVO);
        System.out.println(Thread.currentThread());
        return userService.login(userRegisterVO.getUsername(),userRegisterVO.getPassword());
    }

}
