package com.Lnn.service;

import com.Lnn.DTO.ClubPageQueryDTO;
import com.Lnn.entity.Club;
import com.Lnn.result.PageResult;


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
     * @param club
     */
    void addNewClub(Club club);

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
}
