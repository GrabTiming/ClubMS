package com.Lnn.controller;

import com.Lnn.DTO.ClubPageQueryDTO;
import com.Lnn.DTO.UserClubQueryDTO;
import com.Lnn.entity.Club;
import com.Lnn.entity.UserClub;
import com.Lnn.mapper.ClubMapper;
import com.Lnn.mapper.UserClubMapper;
import com.Lnn.result.PageResult;
import com.Lnn.result.RestBean;
import com.Lnn.service.ClubService;
import com.Lnn.util.Constant;
import com.Lnn.util.JwtProperties;
import com.Lnn.vo.requestVO.*;
import com.Lnn.vo.responseVO.ClubApplicationVO;
import com.Lnn.vo.responseVO.SignStateVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.bcel.Const;
import org.apiguardian.api.API;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/club")
@Slf4j
public class ClubController {

    @Autowired
    private ClubService clubService;


    /**
     * 分页查询所有的社团
     * @return
     */
    @PostMapping("/all")
    public RestBean<PageResult> getAllClub(@RequestBody ClubPageQueryDTO clubPageQueryDTO){
        PageResult pageResult = clubService.pageQuery(clubPageQueryDTO);
        System.out.println(pageResult);
        return RestBean.success(pageResult,"社团查询成功");
    }



    /**
     * 查询 未申请过的社团
     * @param userClubQueryDTO
     * @return
     */
    @PostMapping("/search/unIncluded")
    public RestBean<PageResult> getAllClubAbsent(@RequestBody UserClubQueryDTO userClubQueryDTO)
    {
        PageResult pageResult = clubService.getAllClubAbsent(userClubQueryDTO);
        System.out.println(pageResult);
        return RestBean.success(pageResult,"社团查询成功");
    }


    /**
     * 查询 申请过的社团
     * @param userClubQueryDTO
     * @return
     */
    @PostMapping("/search/included")
    public RestBean<PageResult> getAllClubIncluded(@RequestBody UserClubQueryDTO userClubQueryDTO)
    {
        PageResult pageResult = clubService.getAllClubIncluded(userClubQueryDTO);
        System.out.println(pageResult);
        return RestBean.success(pageResult,"社团查询成功");
    }

    /**
     * 申请加入社团
     */
    @PostMapping("/signIn")
    public RestBean signIn(@RequestBody ClubSignInVO clubSignInVO)
    {
        return clubService.addSignIn(clubSignInVO);
    }


    @PostMapping("/updateSignIn")
    public RestBean updateSignIn(@RequestBody UpdateSignInVO updateSignInVO)
    {
        clubService.updateSignIn(updateSignInVO);
        return RestBean.success();
    }


    //根据社团id 返回 加入这个社团的申请
    @GetMapping("/club-signIn/{clubId}")
    public RestBean<List<SignStateVO>> getSignInByClubId(@PathVariable("clubId") Integer clubId)
    {
        return RestBean.success(clubService.getSignInByClubId(clubId));
    }

    //用户退出社团
    @DeleteMapping("/club-signOut")
    public RestBean deleteUserClub(@RequestParam("userId") Integer userId,
                                   @RequestParam("clubId") Integer clubId)
    {
        clubService.deleteUserClub(userId,clubId);
        return RestBean.success();
    }


    /**
     * 提交社团创建申请
     */
    @PostMapping("/add-clubApplication")
    public RestBean addNewClubApplication(@RequestBody ClubApplicationCreateVO vo){

        if(clubService.getClubName(vo.getClubName())>0)
        {
            return RestBean.failure(400,"社团名重复");
        }
        if(clubService.getClubApplication(vo.getUserid(),vo.getClubName())>0)
        {
            return RestBean.failure(400,"社团创建申请重复提交！");
        }
        clubService.addNewClubApplication(vo);
        return RestBean.success(null,"社团("+vo.getClubName()+")创建申请已提交");
    }

    /**
     * 修改  社团创建申请 状态
     */
    @PostMapping("/update-clubApplication")
    public RestBean updateClubApplication(@RequestBody UpdateClubApplicationVO vo){

        return clubService.updateClubApplication(vo);
    }

    //根据用户id查询 他 创建社团的申请
    @GetMapping ("/get-clubApplication/{id}")
    public RestBean<List<ClubApplicationVO>> getClubApplicationByUserId(@PathVariable("id") Integer userId)
    {
        return RestBean.success(clubService.getClubApplicationByUserId(userId));
    }

    //用户点击确认后删除 创建社团申请 信息
    @DeleteMapping("/delete-clubApplication/{id}")
    public RestBean deleteClubApplication(@PathVariable("id") Integer id)
    {
        clubService.deleteClubApplication(id);
        return RestBean.success();
    }

    //管理员权限 查看所有
    @GetMapping ("/get-allClubApplication")
    public RestBean<List<ClubApplicationVO>> getAllClubApplication()
    {
        return RestBean.success(clubService.getAllClubApplication());
    }

    /**
     * 新增社团
     * @param clubCreateVO 创建用户的VO数据
     * @return
     */
    @PostMapping("/add")
    public RestBean addNewClub(@RequestBody ClubCreateVO clubCreateVO){

        if(clubService.getClubName(clubCreateVO.getName())>0)
        {
            return RestBean.failure(400,"社团名重复");
        }
        Club club = clubService.addNewClub(clubCreateVO);

        return RestBean.success(club,"已添加社团："+club.getName());
    }


    /**
     * 删除社团
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public RestBean delete(@PathVariable("id") Integer id){
        log.info("删除社团：{}",id);
        clubService.delete(id);
        return RestBean.success(null,"删除成功");
    }

    /**
     * 修改社团信息
     * @param club
     * @return
     */
    @PutMapping
    public RestBean update(@RequestBody Club club){
        log.info("修改社团信息：{}",club);
        clubService.update(club);
        return RestBean.success(null,"修改成功");
    }

}
