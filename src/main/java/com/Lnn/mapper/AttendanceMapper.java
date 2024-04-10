package com.Lnn.mapper;

import com.Lnn.entity.Attendance;
import com.Lnn.vo.responseVO.AttendanceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * 签到表相关sql操作
 */
@Mapper
public interface AttendanceMapper {

    //查询活动签到情况
    List<AttendanceVO> inquireByActivity(Integer activityId);

    //查询用户签到情况
    List<AttendanceVO> inquireByUser(Integer userId);

    //更新签到状态
    AttendanceVO update(Integer userId,Integer activityId,Integer state);


}
