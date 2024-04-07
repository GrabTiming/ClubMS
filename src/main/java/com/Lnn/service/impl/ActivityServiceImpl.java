package com.Lnn.service.impl;

import com.Lnn.entity.Activity;
import com.Lnn.entity.RestBean;
import com.Lnn.mapper.ActivityMapper;
import com.Lnn.service.ActivityService;
import com.Lnn.util.Constant;
import com.Lnn.vo.requestVO.ActivityCreateVO;
import com.Lnn.vo.responseVO.ActivityVO;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * (Activity)表服务实现类
 *
 * @since 2024-04-06 19:17:05
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    //1. 查询所有进行中的活动信息;
    @Override
    public List<ActivityVO> getAllActivity() {
        return activityMapper.getAllActivity();
    }

    @Override
    public RestBean<String> addActivity(ActivityCreateVO vo) {

        //判断活动名是否相同
        if(activityMapper.activityNameExits(vo.getName())>0)
        {
            return RestBean.failure(401, Constant.CREATE_ACTIVITY_REPEAT);
        }

        if(activityMapper.add(vo))
        {
            return RestBean.success(null);
        }
        else return RestBean.failure(500,Constant.SYSTEM_ERROR);
    }

    @Override
    public RestBean<String> updateActivity(ActivityVO activityVO) {
        if(activityMapper.activityNameExits(activityVO.getName())>0)
        {
            return RestBean.failure(401, Constant.CREATE_ACTIVITY_REPEAT);
        }
        if(activityMapper.update(activityVO))
        {
            return RestBean.success(null);
        }
        else return RestBean.failure(500,Constant.SYSTEM_ERROR);

    }
}
