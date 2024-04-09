package com.Lnn.service.impl;


import com.Lnn.result.RestBean;
import com.Lnn.entity.User;
import com.Lnn.mapper.UserMapper;
import com.Lnn.service.UserService;
import com.Lnn.util.Constant;
import com.Lnn.vo.responseVO.LoginUserVO;
import org.springframework.beans.BeanUtils;
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

    //注册
    @Override
    public RestBean<User> register(String username, String password) {

        //判断是否重名
        if(userMapper.findUserName(username)>0)
        {
            return RestBean.failure(400, Constant.REGISTER_USERNAME_REPEAT);
        }

        if(userMapper.addUser(username,password))
        {
            User user = userMapper.getByUserName(username);
            return RestBean.success(user,Constant.REGISTER_SUCCESS);
        }
        else //到这说明插入失败，数据库问题
        {
            return RestBean.failure(500,Constant.SYSTEM_ERROR);
        }

    }


    //登录
    @Override
    public RestBean<LoginUserVO> login(String username, String password) {

        System.out.println(username+" "+password);
        if(username==null) return RestBean.failure(400,"用户名为空");
        User user = userMapper.getByUserName(username);
        if(user==null) return RestBean.failure(400,"用户名不存在");
        if(user.getPassword().equals(password))
        {
            LoginUserVO vo = new LoginUserVO();
            BeanUtils.copyProperties(user,vo);
            return RestBean.success(vo,Constant.LOGIN_SUCCESS);
        }
        else return RestBean.failure(400,Constant.LOGIN_FAILURE);

    }

    //修改密码
    @Override
    public User getById(Integer userId) {
        return userMapper.getById(userId);
    }
}