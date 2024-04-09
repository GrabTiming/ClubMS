package com.Lnn.controller;

import com.Lnn.result.RestBean;
import com.Lnn.entity.User;
import com.Lnn.service.UserService;
import com.Lnn.vo.requestVO.UserRegisterVO;
import com.Lnn.vo.responseVO.LoginUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


//    @PostMapping("/register")
//    public RestBean<String> register(@RequestParam("username") String username,@RequestParam("password") String password)
//    {
//        return userService.register(username,password);
//    }

    //注册
    @PostMapping("/register")
    public RestBean<User> register(@RequestBody UserRegisterVO userRegisterVO)
    {
        System.out.println(userRegisterVO);
        return userService.register(userRegisterVO.getUsername(),userRegisterVO.getPassword());
    }

    //登录
    @PostMapping("/login")
    public RestBean<LoginUserVO> login(@RequestBody UserRegisterVO userRegisterVO)
    {
        System.out.println(userRegisterVO);
        System.out.println(Thread.currentThread());
        return userService.login(userRegisterVO.getUsername(),userRegisterVO.getPassword());
    }

    //修改密码
    @PostMapping("/chagePwd")
    public RestBean<User> changePwd(Integer newPwd){
        log.info("修改密码：{}",newPwd);
        userService.getById(newPwd);
        return RestBean.success();
    }


}