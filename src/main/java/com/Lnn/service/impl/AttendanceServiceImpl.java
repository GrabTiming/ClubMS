package com.Lnn.service.impl;

import com.Lnn.entity.Attendance;

import com.Lnn.mapper.AttendanceMapper;
import com.Lnn.service.AttendanceService;
import com.Lnn.vo.responseVO.AttendanceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<AttendanceVO> inquireByActivity(Integer activityId) {
        return attendanceMapper.inquireByActivity(activityId);
    }

    //查询用户签到情况
    @Override
    public List<AttendanceVO> inquireByUser(Integer userId) {

        return attendanceMapper.inquireByUser(userId);
    }

    //更新签到状态
    @Override
    public AttendanceVO update(Integer userId,Integer activityId,Integer state) {

        return attendanceMapper.update(userId,activityId,state);
    }
}
