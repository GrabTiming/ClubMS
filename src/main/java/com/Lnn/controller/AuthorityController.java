package com.Lnn.controller;

import com.Lnn.result.RestBean;
import com.Lnn.service.AuthorityService;
import com.Lnn.vo.requestVO.UpdateAuthorityVO;
import com.Lnn.vo.requestVO.UpdateRoleVO;
import com.Lnn.vo.responseVO.ClubAuthorityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authority")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;


    //获取用户账号权限

    //查看与之有关的社团的 权限
    @GetMapping("/club-authority/{id}")
    public RestBean<List<ClubAuthorityVO>> getClubAuthority(@PathVariable("id") Integer id)
    {

        return RestBean.success(authorityService.getClubAuthorityByUserId(id));
    }


    //更新权限
    @PostMapping("/club-authority/updateAuthority")
    public RestBean updateAuthority(@RequestBody UpdateAuthorityVO vo)
    {
        return authorityService.updateAuthority(vo);
    }


    //授权
    @PostMapping("/club-authority/updateRole")
    public RestBean updateRole(@RequestBody UpdateRoleVO vo)
    {
        return authorityService.updateRole(vo);
    }

}
