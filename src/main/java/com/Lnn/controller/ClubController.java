package com.Lnn.controller;

import com.Lnn.DTO.ClubPageQueryDTO;
import com.Lnn.entity.Club;
import com.Lnn.mapper.ClubMapper;
import com.Lnn.result.PageResult;
import com.Lnn.result.RestBean;
import com.Lnn.service.ClubService;
import lombok.extern.slf4j.Slf4j;
import org.apiguardian.api.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    @GetMapping("/all")
    public RestBean<PageResult> getAllClub(ClubPageQueryDTO clubPageQueryDTO){
        PageResult pageResult = clubService.pageQuery(clubPageQueryDTO);
        System.out.println(pageResult);
        return RestBean.success(pageResult,"社团查询成功");
    }


    /**
     * 新增社团
     * @param club
     * @return
     */
    @PostMapping("/add")
    public RestBean addNewClub(@RequestBody Club club){
        log.info("新增社团:{}",club);
        clubService.addNewClub(club);
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
