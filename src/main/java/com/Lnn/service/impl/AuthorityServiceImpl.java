package com.Lnn.service.impl;

import com.Lnn.mapper.UserClubMapper;
import com.Lnn.result.PageResult;
import com.Lnn.result.RestBean;
import com.Lnn.service.AuthorityService;
import com.Lnn.util.Constant;
import com.Lnn.vo.requestVO.UpdateAuthorityVO;
import com.Lnn.vo.requestVO.UpdateRoleVO;
import com.Lnn.vo.responseVO.ClubAuthorityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private UserClubMapper userClubMapper;


    //查看与之有关的社团的 权限
    @Override
    public List<ClubAuthorityVO> getClubAuthorityByUserId(Integer userId) {

        return userClubMapper.getClubAuthorityByUserId(userId);

    }

    //更新权限
    @Override
    public RestBean updateAuthority(UpdateAuthorityVO updateAuthorityVO) {

        if(userClubMapper.updateAuthority(updateAuthorityVO)>0)
        {
            return RestBean.success(null,"权限修改成功");
        }
        else return RestBean.failure(500, Constant.SYSTEM_ERROR);

    }

    //授权
    @Override
    public RestBean updateRole(UpdateRoleVO updateRoleVO) {
        if(userClubMapper.updateRole(updateRoleVO)>0)
        {
            return RestBean.success(null,"身份修改成功");
        }
        else return RestBean.failure(500, Constant.SYSTEM_ERROR);
    }
}
