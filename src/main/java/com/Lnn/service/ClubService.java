package com.Lnn.service;

import com.Lnn.DTO.ClubPageQueryDTO;
import com.Lnn.DTO.UserClubQueryDTO;
import com.Lnn.entity.Club;
import com.Lnn.result.PageResult;
import com.Lnn.result.RestBean;
import com.Lnn.vo.requestVO.*;
import com.Lnn.vo.responseVO.ClubApplicationVO;
import com.Lnn.vo.responseVO.SignStateVO;

import java.util.List;


/**
 * (Club)表服务接口
 *
 * @author makejava
 * @since 2024-04-06 19:17:18
 */
public interface ClubService {

    /**
     * 分页查询所有的社团
     * @return
     */
    PageResult  pageQuery(ClubPageQueryDTO clubPageQueryDTO);

    /**
     * 新增社团
     * @param clubCreateVO
     */
    Club addNewClub(ClubCreateVO clubCreateVO);

    /**
     * 删除社团
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改社团
      * @param club
     */
    void update(Club club);

    PageResult getAllClubAbsent(UserClubQueryDTO clubPageQueryDTO);
    PageResult getAllClubIncluded(UserClubQueryDTO clubPageQueryDTO);

    //查询社团名是否存在
    int getClubName(String clubName);


    Integer getClubApplication(Integer userId,String clubName);

    void addNewClubApplication(ClubApplicationCreateVO vo);

    RestBean updateClubApplication(UpdateClubApplicationVO vo);

    List<ClubApplicationVO> getClubApplicationByUserId(Integer userId);

    List<ClubApplicationVO> getAllClubApplication();


    RestBean addSignIn(ClubSignInVO clubSignInVO);


    List<SignStateVO> getSignInByClubId(Integer clubId);

    void updateSignIn(UpdateSignInVO updateSignInVO);


    //删除
    void deleteClubApplication(Integer id);


    void deleteUserClub(Integer userId, Integer clubId);
}
