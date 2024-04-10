package com.Lnn.mapper;

import com.Lnn.entity.UserActivity;
import com.Lnn.vo.responseVO.ActivityVO;
import com.Lnn.vo.responseVO.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserActivityMapper {
    List<ActivityVO> getActivitiesByUserId(int userId);

    //根据用户id查询参加的活动
    List<UserVO> getUserByActivityId(int activityId);

    //用户报名活动
    Integer insert(Integer userId,Integer activityId,Integer state);

    //修改报名状态：未审核0 -> 1未通过 2 通过
    Integer update(Integer userId,Integer activityId,Integer state);
    //删除信息
    void delete(Integer userId,Integer activityId);

    int exists(Integer userId, Integer activityId);
}
