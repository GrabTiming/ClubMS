package com.Lnn;

import com.Lnn.mapper.ActivityMapper;
import com.Lnn.mapper.UserActivityMapper;
import com.Lnn.service.ActivityService;
import com.Lnn.service.UserActivityService;
import com.Lnn.util.Constant;
import com.Lnn.vo.requestVO.ActivityCreateVO;
import com.Lnn.vo.requestVO.ActivityRegisterVO;
import com.Lnn.vo.responseVO.ActivityVO;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class ActivityTest {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private ActivityService activityService;

    //插入活动测试
    @Test
    public void addTest() throws ParseException {
        Integer clubId = 1;
        String activityName = "全国第二十届数学竞赛";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 将字符串转化为日期

        Date start_time = sdf.parse("2023-11-11 11:11:11");
        Date end_time = sdf.parse("2053-11-11 11:11:11");;

        String description = "激发青年人的数学才能；引起青年对数学的兴趣；发现科技人才的后备军；促进各国数学教育的交流与发展。";

        ActivityCreateVO vo = new ActivityCreateVO(activityName,clubId,description,start_time,end_time);

        activityMapper.add(vo);
    }

    //更新活动测试
    @Test
    public void updateTest() throws ParseException {
        ActivityVO activity = activityMapper.getByActivityName("全国第二十届数学竞赛");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date end_time = sdf.parse("2063-11-11 11:11:11");;
        activity.setEndTime(end_time);

        activityMapper.update(activity);
    }

    //活动报名
    @Test
    public void ActivityRegister()
    {
        ActivityRegisterVO vo = new ActivityRegisterVO("Lnn","全国第二十届数学竞赛",Constant.ACTIVITY_DEFAULT_STATUS);
        activityService.addUserRegister(vo);
    }


}
