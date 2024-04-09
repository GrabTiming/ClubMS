package com.Lnn.mapper;

import com.Lnn.entity.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;


/**
 * 签到表相关sql操作
 */
@Mapper
public interface AttendanceMapper {

    //查询活动签到情况
    Attendance inquireByActivity(int activityId);

    //查询用户签到情况
    Attendance inquireByUser(int userId);

    //更新签到状态
    Attendance update(String state,int userId);


}
