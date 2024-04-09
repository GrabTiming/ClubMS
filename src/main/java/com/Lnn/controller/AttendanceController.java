package com.Lnn.controller;

import com.Lnn.entity.Attendance;
import com.Lnn.result.RestBean;
import com.Lnn.service.AttendanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("attend")
@Slf4j
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;


    //查询活动签到情况
    @PostMapping("inquireActivity")
    public RestBean<Attendance> inquireByActivity(@RequestBody int activityId){

        Attendance attendance = attendanceService.inquireByActivity(activityId);

        return RestBean.success(attendance);
    }


    //查询用户签到情况

    @PostMapping("inquireUser")
    public RestBean<Attendance> inquireByUser(@RequestBody int userId){

        Attendance attendance = attendanceService.inquireByUser(userId);

        return RestBean.success(attendance);
    }

    //更新签到状态
    @PostMapping("update")
    public RestBean<Attendance> update(@RequestBody String state,@RequestBody int userId){
        Attendance attendance = attendanceService.update(state,userId);

        return RestBean.success(attendance);
    }
}
