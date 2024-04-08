package com.Lnn.service;

import com.Lnn.result.RestBean;
import com.Lnn.vo.requestVO.UpdateAuthorityVO;
import com.Lnn.vo.requestVO.UpdateRoleVO;
import com.Lnn.vo.responseVO.ClubAuthorityVO;

import java.util.List;


public interface AuthorityService {


    List<ClubAuthorityVO> getClubAuthorityByUserId(Integer userId);

    RestBean updateAuthority(UpdateAuthorityVO updateAuthorityVO);

    RestBean updateRole(UpdateRoleVO updateRoleVO);

}
