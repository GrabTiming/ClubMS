package com.Lnn.service.impl;

import com.Lnn.entity.Activity;
import com.Lnn.entity.Payment;
import com.Lnn.entity.User;
import com.Lnn.mapper.*;
import com.Lnn.result.RestBean;
import com.Lnn.service.ActivityService;
import com.Lnn.util.Constant;
import com.Lnn.vo.requestVO.ActivityCreateVO;
import com.Lnn.vo.requestVO.ActivityRegisterVO;
import com.Lnn.vo.responseVO.ActivityVO;
import com.Lnn.vo.responseVO.DeleteActivityRegisterVO;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * (Activity)表服务实现类
 *
 * @since 2024-04-06 19:17:05
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private UserActivityMapper userActivityMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Autowired
    private PaymentMapper paymentMapper;


    //1. 查询所有进行中的活动信息;
    @Override
    public List<ActivityVO> getAllActivity() {
        return activityMapper.getAllActivity();
    }

    //2. 新增活动
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

    //更新活动信息
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

    //更新报名信息
    @Override
    public RestBean addUserRegister(ActivityRegisterVO vo) {
        Integer userId = userMapper.getIdByUsername(vo.getUsername());
        Integer activityId = activityMapper.getIdByActivityName(vo.getActivityName());

        if(userActivityMapper.exists(userId,activityId)>0)
        {
            return RestBean.failure(400,"请勿重复报名");
        }

        if(userActivityMapper.insert(userId,activityId,Constant.DEFAULT_STATUS)>0)
        {
            return RestBean.success(null,"报名成功");
        }
        return RestBean.failure(400,Constant.SYSTEM_ERROR);

    }

    //活动报名 对用户报名活动 设置状态
    @Override
    public RestBean<String> updateUserRegister(ActivityRegisterVO vo) {
        Integer userId = userMapper.getIdByUsername(vo.getUsername());
        Integer activityId = activityMapper.getIdByActivityName(vo.getActivityName());

        if(userActivityMapper.update(userId,activityId,vo.getState())>0)
        {
            //报名成功
            if(Objects.equals(vo.getState(), Constant.ACCESS_STATUS))
            {
                attendanceMapper.insert(userId,activityId,vo.getState());

                Payment payment = new Payment(userId,activityId,vo.getCost(),vo.getState());
                paymentMapper.insert(payment);
            }
            else userActivityMapper.delete(userId,activityId);//报名失败之间删除
            return RestBean.success(null,"审核成功");
        }
        else return RestBean.failure(400,Constant.SYSTEM_ERROR);

    }

    @Override
    public List<ActivityVO> getActivityByUserId(Integer userId) {

        return userActivityMapper.getActivitiesByUserId(userId);

    }

    @Override
    public RestBean deleteRegister(DeleteActivityRegisterVO vo) {
        Integer userId = userMapper.getIdByUsername(vo.getUsername());
        Integer activityId = activityMapper.getIdByActivityName(vo.getActivityName());

        userActivityMapper.delete(userId,activityId);
        return RestBean.success(null,"退出活动成功");
    }


}
