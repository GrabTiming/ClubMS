package com.Lnn.service;

import com.Lnn.result.RestBean;
import com.Lnn.vo.requestVO.UpdateAuthorityVO;
import com.Lnn.vo.requestVO.UpdateRoleVO;
import com.Lnn.vo.responseVO.ClubAuthorityVO;

import java.util.List;


public interface AuthorityService {

    //查看与之有关的社团的 权限
    List<ClubAuthorityVO> getClubAuthorityByUserId(Integer userId);


    //更新权限
    RestBean updateAuthority(UpdateAuthorityVO updateAuthorityVO);

    //授权
    RestBean updateRole(UpdateRoleVO updateRoleVO);

}
