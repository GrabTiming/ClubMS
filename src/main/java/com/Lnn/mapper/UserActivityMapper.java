package com.Lnn.mapper;

import com.Lnn.vo.responseVO.ActivityVO;
import com.Lnn.vo.responseVO.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserActivityMapper {
    List<ActivityVO> getActivitiesByUserId(int userId);

    //根据用户id查询参加的活动
    List<UserVO> getUserByActivityId(int activityId);

    //用户参加活动后，增加
    void insert(Integer userId,Integer activityId,Integer state);

    //删除信息
    void delete(Integer activityId);

}
