package com.Lnn.mapper;


import com.Lnn.vo.requestVO.ActivityCreateVO;
import com.Lnn.vo.responseVO.ActivityVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 活动表相关sql操作
 */
@Mapper
public interface ActivityMapper {
    //查询活动信息
    List<ActivityVO> getAllActivity();


    ActivityVO getByActivityName(String activityName);

    //增加活动
    boolean add(ActivityCreateVO vo);


    //修改活动信息
    boolean update(ActivityVO activityVO);


    Integer activityNameExits(String name);

}
