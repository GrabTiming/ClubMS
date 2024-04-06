package com.Lnn.service.impl;


import com.Lnn.entity.RestBean;
import com.Lnn.entity.User;
import com.Lnn.mapper.UserMapper;
import com.Lnn.service.UserService;
import com.Lnn.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2024-04-06 19:17:29
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public RestBean<String> register(String username, String password) {

        //判断是否重名
        if(userMapper.findUserName(username)>0)
        {
            return RestBean.failure(405, Constant.REGISTER_USERNAME_REPEAT);
        }

        if(userMapper.addUser(username,password))
        {
            return RestBean.success(Constant.REGISTER_SUCCESS);
        }
        else //到这说明插入失败，数据库问题
        {
            return RestBean.failure(500,Constant.SYSTEM_ERROR);
        }

    }

    @Override
    public RestBean<String> login(String username, String password) {

        User user = userMapper.getByUserName(username);

        if(user.getPassword().equals(password))
        {
            return RestBean.success();
        }
        else return RestBean.failure(403,Constant.LOGIN_FAILURE);

    }
}
