package com.Lnn.service;

import com.Lnn.entity.Activity;
import com.Lnn.result.RestBean;
import com.Lnn.vo.requestVO.ActivityCreateVO;
import com.Lnn.vo.requestVO.ActivityRegisterVO;
import com.Lnn.vo.responseVO.ActivityVO;
import com.Lnn.vo.responseVO.DeleteActivityRegisterVO;
import com.Lnn.vo.responseVO.UserVO;

import java.util.List;

/**
 * (Activity)表服务接口
 *
 * @author makejava
 * @since 2024-04-06 19:17:05
 */
public interface ActivityService {


    //1. 查询所有进行中的活动信息;
    List<ActivityVO> getAllActivity();

    //2. 新增活动
    RestBean<String> addActivity(ActivityCreateVO vo);

    //6. 更新活动信息
    RestBean<String> updateActivity(ActivityVO activityVO);


    // 新增用户报名信息
    RestBean addUserRegister(ActivityRegisterVO vo);

    //修改用户报名信息
    RestBean<String> updateUserRegister(ActivityRegisterVO vo);


    List<ActivityVO> getActivityByUserId(Integer userId);

    RestBean deleteRegister(DeleteActivityRegisterVO vo);

}
