package com.Lnn.service;

import com.Lnn.result.RestBean;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-04-06 19:17:29
 */
public interface UserService {


    //注册
    RestBean<String> register(String username, String password);

    //登录
    RestBean<String> login(String username,String password);


    //修改密码

}
