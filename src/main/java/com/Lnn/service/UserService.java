package com.Lnn.service;

import com.Lnn.entity.User;
import com.Lnn.result.RestBean;
import com.Lnn.vo.responseVO.LoginUserVO;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-04-06 19:17:29
 */
public interface UserService {


    //注册
    RestBean<User> register(String username, String password);

    //登录
    RestBean<LoginUserVO> login(String username, String password);


    //修改密码

    User getById(Integer userId);

}
