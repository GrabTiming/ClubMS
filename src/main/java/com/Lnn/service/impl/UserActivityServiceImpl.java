package com.Lnn.service.impl;

import com.Lnn.entity.Activity;
import com.Lnn.mapper.UserActivityMapper;
import com.Lnn.service.UserActivityService;
import com.Lnn.vo.responseVO.ActivityVO;
import com.Lnn.vo.responseVO.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserActivityServiceImpl implements UserActivityService {

    @Autowired
    private UserActivityMapper userActivityMapper;

    @Override
    public List<ActivityVO> getActivitiesByUserId(int userId) {

        return userActivityMapper.getActivitiesByUserId(userId);
    }

    //根据活动id返回参加的用户
    @Override
    public List<UserVO> getUserByActivityId(int activityId) {
        return userActivityMapper.getUserByActivityId(activityId);
    }

    @Override
    public void insert(Integer userId, Integer activityId, Integer state) {

        userActivityMapper.insert(userId,activityId,state);

    }

    @Override
    public void deleteByActivityId(Integer activityId) {
        userActivityMapper.delete(activityId);
    }


}
