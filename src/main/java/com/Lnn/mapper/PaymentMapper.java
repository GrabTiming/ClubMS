package com.Lnn.mapper;

import com.Lnn.entity.Payment;
import com.Lnn.vo.responseVO.PaymentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
    Integer insert(Payment payment);

    List<PaymentVO> getPaymentByUserId(Integer userId);

    List<PaymentVO> getPaymentByActivityId(Integer activityId);


    //增加缴费信息

    //查询缴费信息

}
