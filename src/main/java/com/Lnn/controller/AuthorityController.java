package com.Lnn.controller;

import com.Lnn.entity.User;
import com.Lnn.mapper.UserMapper;
import com.Lnn.result.RestBean;
import com.Lnn.service.AuthorityService;
import com.Lnn.service.UserService;
import com.Lnn.vo.responseVO.ClubAuthorityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
