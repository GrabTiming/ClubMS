package com.Lnn.controller;


import com.Lnn.mapper.ActivityMapper;
import com.Lnn.result.RestBean;
import com.Lnn.service.ActivityService;
import com.Lnn.vo.requestVO.ActivityCreateVO;
import com.Lnn.vo.requestVO.ActivityRegisterVO;
import com.Lnn.vo.responseVO.ActivityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;


    //1. 查询所有进行中的活动信息;
    @GetMapping("/all")
    public RestBean<List<ActivityVO>> getAll()
    {
        return RestBean.success(activityService.getAllActivity());
    }


    //查询单个用户参加的所有活动
    @GetMapping("/user/{id}")
    public RestBean<List<ActivityVO>> getActivityByUserId(@PathVariable("id") Integer userId)
    {
        return RestBean.success(activityService.getActivityByUserId(userId));
    }

    //2. 新增活动
    @PostMapping("/create")
    public RestBean<String> createActivity(@RequestBody ActivityCreateVO vo)
    {
        return activityService.addActivity(vo);
    }

    /**
     * 活动报名
     * @param vo 用户信息
     * @return 用户
     */
    @PostMapping("/userRegister")
    public RestBean<String> userRegister(@RequestBody ActivityRegisterVO vo)
    {
        return activityService.addUserRegister(vo);
    }

    //更新报名信息
    @PostMapping("/updateUserRegister")
    public RestBean<String> updateUserRegister(@RequestBody ActivityRegisterVO vo)
    {
        return activityService.updateUserRegister(vo);
    }

    /**
     * 更新活动信息
     * @param activityVO
     * @return
     */
    @PostMapping("updateActivity")
    public RestBean updateActivity (@RequestBody ActivityVO activityVO){
        activityService.updateActivity(activityVO);
        return  RestBean.success();

    }


}
