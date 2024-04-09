package com.Lnn.mapper;

import com.Lnn.vo.requestVO.UpdateAuthorityVO;
import com.Lnn.vo.requestVO.UpdateRoleVO;
import com.Lnn.vo.responseVO.ClubAuthorityVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserClubMapper {


    List<ClubAuthorityVO> getClubAuthorityByUserId(Integer userId);

    Integer updateAuthority(UpdateAuthorityVO updateAuthorityVO);

    Integer updateRole(UpdateRoleVO updateRoleVO);

    void add(int userId, int clubId, int i, int i1, int i2);
}
