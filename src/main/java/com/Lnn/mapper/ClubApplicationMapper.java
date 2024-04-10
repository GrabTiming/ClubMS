package com.Lnn.mapper;


import com.Lnn.entity.ClubApplication;
import com.Lnn.vo.requestVO.ClubApplicationCreateVO;
import com.Lnn.vo.requestVO.UpdateClubApplicationVO;
import com.Lnn.vo.responseVO.ClubApplicationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 社团创建的申请表
 *
 * @since 2024-04-10 08:11:49
 */
@Mapper
public interface ClubApplicationMapper {


    //获取所有申请信息
    List<ClubApplicationVO> getAll();

    //根据用户id查询申请信息
    List<ClubApplicationVO> getByUserId(Integer userId);

    //添加申请
    Integer insert(ClubApplicationCreateVO clubApplicationCreateVO);

    //修改申请状态
    Integer update(UpdateClubApplicationVO vo);


    //删除申请
    Integer delete(Integer id);

    //查询是否存在重复的申请
    Integer searchClubApplication(Integer userId, String clubName);

    ClubApplication get(Integer userId, String clubName);
}

