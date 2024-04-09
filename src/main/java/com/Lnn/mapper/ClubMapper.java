package com.Lnn.mapper;

import com.Lnn.DTO.ClubPageQueryDTO;
import com.Lnn.DTO.UserClubQueryDTO;
import com.Lnn.entity.Club;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;


/**
 * 社团表相关sql操作
 */
@Mapper
public interface ClubMapper {


    /**
     * 分页查询社团
     * @return
     */
    Page<Club> pageQuery(ClubPageQueryDTO clubPageQueryDTO);
    /**
     * 增加社团
     *
     * @param club
     * @return
     */
    int insert(Club club);

    /**
     *根据社团id删除社团
     * @param id
     */
    @Delete("delete from club where id = #{id}")
    void delete(Integer id);

    /**
     * 修改社团信息
     * @param club
     */
    void update(Club club);

    Page<Club> getAllClubAbsent(UserClubQueryDTO userClubQueryDTO);

    Page<Club> getAllClubIncluded(UserClubQueryDTO userClubQueryDTO);


    int getClubName(String clubName);
}
