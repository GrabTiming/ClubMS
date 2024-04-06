package com.Lnn.service;

import com.Lnn.vo.responseVO.ActivityVO;
import com.Lnn.vo.responseVO.UserVO;

import java.util.List;

public interface UserActivityService {

    //根据用户的id查询参加的活动
    List<ActivityVO> getActivitiesByUserId(int userId);
    //根据活动id查询参加的用户
    List<UserVO> getUserByActivityId(int activityId);

    void insert(Integer userId,Integer activityId,Integer state);

    void deleteByActivityId(Integer activityId);

}
