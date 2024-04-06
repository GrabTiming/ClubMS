package com.Lnn.mapper;

import com.Lnn.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {


    //获取所有用户
    List<User>  getAllUser();


    Integer findUserName(String username);


    boolean addUser(String username, String password);


    User getByUserName(String username);
}
