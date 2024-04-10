package com.Lnn.service.impl;

import com.Lnn.DTO.ClubPageQueryDTO;
import com.Lnn.DTO.UserClubQueryDTO;
import com.Lnn.entity.Club;
import com.Lnn.entity.ClubApplication;
import com.Lnn.entity.UserClub;
import com.Lnn.mapper.ClubApplicationMapper;
import com.Lnn.mapper.ClubMapper;
import com.Lnn.mapper.UserClubMapper;
import com.Lnn.result.PageResult;
import com.Lnn.result.RestBean;
import com.Lnn.service.ClubService;
import com.Lnn.util.Constant;
import com.Lnn.vo.requestVO.ClubApplicationCreateVO;
import com.Lnn.vo.requestVO.ClubCreateVO;
import com.Lnn.vo.requestVO.UpdateClubApplicationVO;
import com.Lnn.vo.responseVO.ClubApplicationVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


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

    @Autowired
    private UserClubMapper userClubMapper;

    @Autowired
    private ClubApplicationMapper clubApplicationMapper;

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
     */
    @Override
    //@Transactional//因为涉及多个表，所以加上这个注解，要么全部成功要么全部失败
    public Club addNewClub(ClubCreateVO clubCreateVO) {

        Club club = new Club();
        BeanUtils.copyProperties(clubCreateVO,club);
        clubMapper.insert(club);
        System.out.println(club);

        //还要将创建人 修改为 社团的社长
        UserClub userClub = new UserClub();
        userClub.setClubId(club.getId());
        userClub.setUserId(clubCreateVO.getUserId());
        userClub.setAuthority(Constant.CLUB_LEADER_AUTHORITY);
        userClub.setRole(Constant.CLUB_LEADER_ROLE);
        userClub.setState(Constant.ACCESS_STATUS);
        userClubMapper.insert(userClub);
        return club;
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
    public int getClubName(String clubName) {
        return clubMapper.getClubName(clubName);
    }


    //查询是否存在这个申请
    @Override
    public Integer getClubApplication(Integer userId, String clubName) {
        return clubApplicationMapper.searchClubApplication(userId,clubName);
    }

    @Override
    public void addNewClubApplication(ClubApplicationCreateVO vo) {
         clubApplicationMapper.insert(vo);
    }



    @Override
    public RestBean updateClubApplication(UpdateClubApplicationVO vo) {

        clubApplicationMapper.update(vo);

        if(Objects.equals(vo.getState(), Constant.ACCESS_STATUS))//如果是通过申请
        {
            ClubApplication clubApplication = clubApplicationMapper.get(vo.getUserId(),vo.getClubName());
            ClubCreateVO clubCreateVO = new ClubCreateVO();
            BeanUtils.copyProperties(clubApplication,clubCreateVO);
            clubCreateVO.setName(clubApplication.getClubName());
            if(getClubName(clubCreateVO.getName())>0)
            {
                vo.setState(1);
                clubApplicationMapper.update(vo);
                return RestBean.failure(400,"社团("+clubCreateVO.getName()+")已存在，否决该申请");
            }
            Club club =addNewClub(clubCreateVO);
            return RestBean.success(club,"操作成功,"+"社团("+vo.getClubName()+")创建成功");
        }
        //不是通过就是不通过
        return RestBean.success(null,"操作成功,"+"否决社团("+vo.getClubName()+")创建");
    }

    @Override
    public List<ClubApplicationVO> getClubApplicationByUserId(Integer userId) {

        return clubApplicationMapper.getByUserId(userId);

    }

    @Override
    public List<ClubApplicationVO> getAllClubApplication() {
        return clubApplicationMapper.getAll();
    }
}
