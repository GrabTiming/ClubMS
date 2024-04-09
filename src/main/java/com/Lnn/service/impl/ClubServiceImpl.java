package com.Lnn.service.impl;

import com.Lnn.DTO.ClubPageQueryDTO;
import com.Lnn.DTO.UserClubQueryDTO;
import com.Lnn.entity.Club;
import com.Lnn.mapper.ClubMapper;
import com.Lnn.result.PageResult;
import com.Lnn.service.ClubService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * (Club)表服务实现类
 *
 * @author makejava
 * @since 2024-04-06 19:17:18
 */
@Service("clubService")
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubMapper clubMapper;

    /**
     * 分页查询所有的社团
     * @param clubPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(ClubPageQueryDTO clubPageQueryDTO) {
        PageHelper.startPage(clubPageQueryDTO.getPage(),clubPageQueryDTO.getPageSize());
        Page<Club> page =clubMapper.pageQuery(clubPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }


    /**
     * 增加表
     * @param club
     */
    @Override
    //@Transactional//因为涉及多个表，所以加上这个注解，要么全部成功要么全部失败
    public void addNewClub(Club club) {

        clubMapper.insert(club);
    }

    /**
     * 删除社团
     * @param id
     */
    @Override
    public void delete(Integer id) {
        //todo 判断是否可以删除社团--是否存在有人的社团

        //todo 判断是否可以删除社团--是否有活动关联

        clubMapper.delete(id);

    }

    /**
     * 修改社团
     * @param club
     */
    @Override
    public void update(Club club) {

        clubMapper.update(club);
    }

    /**
     * 返回用户未参加过的社团
     * @return 未参加过的社团列表
     */
    @Override
    public PageResult getAllClubAbsent(UserClubQueryDTO userClubQueryDTO) {

        PageHelper.startPage(userClubQueryDTO.getPage(),userClubQueryDTO.getPageSize());
        Page<Club> page =clubMapper.getAllClubAbsent(userClubQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());

    }

    /**
     * 返回用户申请过的社团
     * @return 申请过的社团列表
     */
    @Override
    public PageResult getAllClubIncluded( UserClubQueryDTO userClubQueryDTO) {
        PageHelper.startPage(userClubQueryDTO.getPage(),userClubQueryDTO.getPageSize());
        Page<Club> page =clubMapper.getAllClubIncluded(userClubQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public int getClubName(Club club) {
        return clubMapper.getClubName(club.getName());
    }
}
