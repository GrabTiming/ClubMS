package com.Lnn.mapper;

import com.Lnn.entity.UserClub;
import com.Lnn.vo.requestVO.UpdateAuthorityVO;
import com.Lnn.vo.requestVO.UpdateRoleVO;
import com.Lnn.vo.requestVO.UserClubCreateVO;
import com.Lnn.vo.responseVO.ClubAuthorityVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserClubMapper {


    //新增用户申请 社团
    Integer insert(UserClub userClub);
    List<ClubAuthorityVO> getClubAuthorityByUserId(Integer userId);

    Integer updateAuthority(UpdateAuthorityVO updateAuthorityVO);

    Integer updateRole(UpdateRoleVO updateRoleVO);

    List<ClubAuthorityVO> getUserAuthorityByClubId(Integer id);
}
