package com.Lnn.service;

import com.Lnn.entity.Attendance;
import com.Lnn.vo.requestVO.UpdateAttendanceVO;
import com.Lnn.vo.responseVO.AttendanceVO;

import java.util.List;

/**
 * (Attendance)表服务接口
 *
 * @author makejava
 * @since 2024-04-06 19:17:11
 */
public interface AttendanceService {

    //查询活动签到情况
    List<AttendanceVO> inquireByActivity(Integer activityId);


    //查询用户签到情况
    List<AttendanceVO> inquireByUser(Integer userId);


    //更新签到状态
    void update(UpdateAttendanceVO vo);





}
