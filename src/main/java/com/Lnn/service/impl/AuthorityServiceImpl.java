package com.Lnn.service.impl;

import com.Lnn.mapper.UserClubMapper;
import com.Lnn.service.AuthorityService;
import com.Lnn.vo.responseVO.ClubAuthorityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private UserClubMapper userClubMapper;

    @Override
    public List<ClubAuthorityVO> getClubAuthorityByUserId(Integer userId) {

        return userClubMapper.getClubAuthorityByUserId(userId);

    }
}
