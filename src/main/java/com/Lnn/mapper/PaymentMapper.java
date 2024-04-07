package com.Lnn.mapper;

import com.Lnn.entity.PaymentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
    List<PaymentVO> getByUserId(Integer userId);

    List<PaymentVO> getByActivityId(Integer activityId);

    Double getSumByActivityId(Integer activityId);

    int insert(Integer userId, Integer activityId, Double cost);

    //增加缴费信息

    //查询缴费信息

}
