package com.Lnn.service;

import com.Lnn.vo.responseVO.ClubAuthorityVO;

import java.util.List;


public interface AuthorityService {


    List<ClubAuthorityVO> getClubAuthorityByUserId(Integer userId);
}
