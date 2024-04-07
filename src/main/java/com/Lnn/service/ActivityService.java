package com.Lnn.service;

import com.Lnn.entity.RestBean;
import com.Lnn.vo.requestVO.ActivityCreateVO;
import com.Lnn.vo.responseVO.ActivityVO;
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


}
