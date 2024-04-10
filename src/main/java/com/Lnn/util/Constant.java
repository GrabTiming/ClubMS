package com.Lnn.util;

public class Constant {

    public static final String REGISTER_USERNAME_REPEAT = "用户名重复";
    public static final String CREATE_ACTIVITY_REPEAT = "活动名重复";
    public static final String REGISTER_SUCCESS= "用户注册成功";
    public static final String SYSTEM_ERROR= "系统出现异常，请联系管理员";
    public static final String LOGIN_FAILURE= "用户名或密码错误";
    public static final String LOGIN_SUCCESS= "登录成功";


    public static final Integer CLUB_LEADER_ROLE = 1;

    /**
     * 社长权限
     */
    public static final Integer CLUB_LEADER_AUTHORITY = 15;
    public static final Integer CLUB_MEMBER_ROLE = 0;



    //活动报名 状态 默认未审核
    public static final Integer DEFAULT_STATUS = 0;

    //活动报名不通过 状态字
    public static final Integer NOT_ACCESS_STATUS = 1;

    //活动报名成功 状态字
    public static final Integer ACCESS_STATUS = 2;

    public static  String TOKEN =null ;




}
