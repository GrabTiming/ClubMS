package com.Lnn.mapper;

import com.Lnn.entity.UserClub;
import com.Lnn.result.RestBean;
import com.Lnn.vo.requestVO.UpdateAuthorityVO;
import com.Lnn.vo.requestVO.UpdateRoleVO;
import com.Lnn.vo.requestVO.UpdateSignInVO;
import com.Lnn.vo.requestVO.UserClubCreateVO;
import com.Lnn.vo.responseVO.ClubAuthorityVO;
import com.Lnn.vo.responseVO.SignStateVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserClubMapper {


    //新增用户申请 社团
    Integer insert(UserClub userClub);

    //获取与用户有关的社团的权限
    List<ClubAuthorityVO> getClubAuthorityByUserId(Integer userId);

    Integer updateAuthority(UpdateAuthorityVO updateAuthorityVO);

    Integer updateRole(UpdateRoleVO updateRoleVO);

    //获取所有社团成员的权限
    List<ClubAuthorityVO> getUserAuthorityByClubId(Integer id);

    List<SignStateVO> getSignInByClubId(Integer clubId);

    void updateSignIn(UpdateSignInVO updateSignInVO);

    void delete(Integer userId, Integer clubId);

    //查询社团的 入团报名申请
}
