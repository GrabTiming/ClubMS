package com.Lnn.mapper;

import com.Lnn.vo.requestVO.PaymentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {

    //根据用户id查询信息
    List<PaymentVO> getByUserId(Integer userId);

    //根据社团id查询信息
    List<PaymentVO> getByActivityId(Integer activityId);

    Double getSumByActivityId(Integer activityId);

    int insert(PaymentVO vo);

    //增加缴费信息

    //查询缴费信息

}
