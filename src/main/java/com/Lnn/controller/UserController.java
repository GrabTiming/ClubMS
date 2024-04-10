package com.Lnn.controller;

import com.Lnn.result.RestBean;
import com.Lnn.entity.User;
import com.Lnn.service.UserService;
import com.Lnn.util.Constant;
import com.Lnn.util.JwtClaimsConstant;
import com.Lnn.util.JwtProperties;
import com.Lnn.util.JwtUtil;
import com.Lnn.vo.requestVO.UserRegisterVO;
import com.Lnn.vo.responseVO.LoginUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

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
        log.info("用户登录：{},",userRegisterVO);

        User user = userService.login(userRegisterVO);

        if(user == null)
            return RestBean.failure(401,"用户不存在或密码错误");

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();

        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        claims.put(JwtClaimsConstant.USERNAME,user.getUsername());
        claims.put(JwtClaimsConstant.USER_ROLE,user.getRole());

        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        Constant.TOKEN = token;

        LoginUserVO loginUserVO = LoginUserVO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .token(token)
                .build();

        return RestBean.success(loginUserVO,"登陆成功");
    }

    //修改密码
    @PostMapping("/chagePwd")
    public RestBean<User> changePwd(Integer newPwd){
        log.info("修改密码：{}",newPwd);
        userService.getById(newPwd);
        return RestBean.success();
    }


}