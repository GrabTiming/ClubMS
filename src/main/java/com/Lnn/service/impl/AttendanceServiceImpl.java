package com.Lnn.service.impl;

import com.Lnn.entity.Attendance;

import com.Lnn.mapper.ActivityMapper;
import com.Lnn.mapper.AttendanceMapper;
import com.Lnn.mapper.UserMapper;
import com.Lnn.service.AttendanceService;
import com.Lnn.vo.requestVO.UpdateAttendanceVO;
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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ActivityMapper activityMapper;

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

    @Override
    public void update(UpdateAttendanceVO vo) {

        String username = vo.getUsername();
        String activityName =vo.getActivityName();
        Integer state = vo.getState();

        Integer userId = userMapper.getIdByUsername(username);
        Integer activityId = activityMapper.getIdByActivityName(activityName);
        attendanceMapper.update(userId,activityId,state);
    }

    //更新签到状态

}
