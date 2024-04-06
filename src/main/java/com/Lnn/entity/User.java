package com.Lnn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (User) 用户表
 *
 * @author makejava
 * @since 2024-04-06 18:51:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  {
   
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色（0普通用户，1管理员，2超级管理员）
     */
    private Integer role;


}

