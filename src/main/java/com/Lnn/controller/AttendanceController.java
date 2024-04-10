package com.Lnn.controller;

import com.Lnn.entity.Attendance;
import com.Lnn.result.RestBean;
import com.Lnn.service.AttendanceService;
import com.Lnn.vo.requestVO.UpdateAttendanceVO;
import com.Lnn.vo.responseVO.AttendanceVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attend")
@Slf4j
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;


    //查询活动签到情况
    @GetMapping("/inquireActivity")
    public RestBean<List<AttendanceVO>> inquireByActivity(@RequestParam int activityId){

        List<AttendanceVO> list = attendanceService.inquireByActivity(activityId);

        return RestBean.success(list);
    }


    //查询用户签到情况
    @GetMapping("/inquireUser")
    public RestBean<List<AttendanceVO>> inquireByUser(@RequestParam int userId){

        List<AttendanceVO> list = attendanceService.inquireByUser(userId);

        return RestBean.success(list);
    }

    //更新签到状态
    @PostMapping("/update")
    public RestBean<AttendanceVO> update(@RequestBody UpdateAttendanceVO vo){

        attendanceService.update(vo);

        return RestBean.success(null,"签到成功");
    }
}