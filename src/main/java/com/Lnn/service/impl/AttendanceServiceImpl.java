package com.Lnn.service.impl;

import com.Lnn.entity.Attendance;

import com.Lnn.mapper.AttendanceMapper;
import com.Lnn.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Attendance)表服务实现类
 *
 * @author makejava
 * @since 2024-04-06 19:17:11
 */
@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    //查询活动签到情况
    @Override
    public Attendance inquireByActivity(int activityId) {
        Attendance attendance = attendanceMapper.inquireByActivity(activityId);
        return attendance;
    }

    //查询用户签到情况
    @Override
    public Attendance inquireByUser(int userId) {
        Attendance attendance = attendanceMapper.inquireByUser(userId);

        return attendance;
    }

    //更新签到状态
    @Override
    public Attendance update(String state,int userId) {

        Attendance attendance = attendanceMapper.update(state,userId);
        return attendance;
    }
}
