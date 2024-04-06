package com.Lnn.service;

import com.Lnn.entity.RestBean;
import com.Lnn.entity.User;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-04-06 19:17:29
 */
public interface UserService {


    //注册
    RestBean<String> register(String username, String password);

    RestBean<String> login(String username,String password);


}
