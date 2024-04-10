package com.Lnn.service;


import com.Lnn.entity.Payment;
import com.Lnn.vo.requestVO.UpdatePaymentVO;
import com.Lnn.vo.responseVO.PaymentVO;

import java.util.List;

/**
 * (Payment)表服务接口
 *
 * @author makejava
 * @since 2024-04-06 19:17:23
 */
public interface PaymentService {

    //根据用户id查询 缴纳的费用
    Integer addPayment(Payment payment);

    List<PaymentVO> getPaymentByUserId(Integer userId);

    List<PaymentVO> getPaymentByActivityId(Integer activityId);

    void update(UpdatePaymentVO vo);
}
