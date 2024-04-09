package com.Lnn.controller;

import com.Lnn.result.RestBean;
import com.Lnn.service.UserActivityService;
import com.Lnn.vo.responseVO.ActivityVO;
import com.Lnn.vo.responseVO.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("userActivity")
@Slf4j
public class UerActivityController {

    @Autowired
    private UserActivityService userActivityService;

    /**
     * 根据用户id找参加的活动
     * @param userId
     * @return
     */
    @PostMapping("all")
    public RestBean< List<ActivityVO>> getActivitiesByUserId(@RequestBody int userId){

        List<ActivityVO> activityVO = userActivityService.getActivitiesByUserId(userId);
        log.info("参加的活动：{}",activityVO);
        return RestBean.success(activityVO);
    }

    /**
     * 根据活动id返回参加的用户
     * @param activityId
     * @return
     */
    @PostMapping("user")
    public RestBean<List<UserVO>> getUserByActivityId(@RequestBody int activityId){
        List<UserVO> userVo = userActivityService.getUserByActivityId(activityId);
        log.info("参加活动的用户:{}",userVo);
        return RestBean.success(userVo);
    }

    //参加活动
    @PostMapping("attend")
    public RestBean insert (@RequestBody Integer userId,@RequestBody Integer activityId,@RequestBody Integer state){
        userActivityService.insert(userId,activityId,state);
        return RestBean.success();
    }

    /**
     * 根据活动ID删除活动
     * @param activityId
     * @return
     */
    public RestBean deleteByActivityId(@RequestBody Integer activityId){
        userActivityService.deleteByActivityId(activityId);
        return RestBean.success();
    }


}
