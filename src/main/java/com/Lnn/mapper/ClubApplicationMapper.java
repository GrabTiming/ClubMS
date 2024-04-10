package com.Lnn.mapper;


import com.Lnn.entity.ClubApplication;
import com.Lnn.vo.requestVO.ClubApplicationCreateVO;
import com.Lnn.vo.responseVO.ClubApplicationVO;

import java.util.List;

/**
 * 社团创建的申请表
 *
 * @since 2024-04-10 08:11:49
 */
public interface ClubApplicationMapper {


    //获取所有申请信息
    List<ClubApplicationVO> getAll();

    //根据用户id查询申请信息
    List<ClubApplicationVO> getByUserId(Integer userId);

    //添加申请
    Integer insert(ClubApplicationCreateVO clubApplicationCreateVO);

    //修改申请状态
    Integer update(Integer id,Integer state);


    //删除申请
    Integer delete(Integer id);
}

