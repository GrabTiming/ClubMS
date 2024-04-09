package com.Lnn.service;

import com.Lnn.entity.Attendance;

/**
 * (Attendance)表服务接口
 *
 * @author makejava
 * @since 2024-04-06 19:17:11
 */
public interface AttendanceService {

    //查询活动签到情况
    Attendance inquireByActivity(int activityId);


    //查询用户签到情况
    Attendance inquireByUser(int userId);


    //更新签到状态
    Attendance update(String state,int userId);





}
