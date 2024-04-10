package com.Lnn.service;

import com.Lnn.vo.requestVO.PaymentVO;

import java.util.List;


/**
 * (Payment)表服务接口
 *
 * @author makejava
 * @since 2024-04-06 19:17:23
 */
public interface PaymentService {

    //根据用户id查询 缴纳的费用
    List<PaymentVO> getByUserId(Integer userId);

    //根据活动查询 缴费的数据
    List<PaymentVO> getByActivityId(Integer activityId);

    //查看活动 缴纳的总金额
    Double getSumByActivityId(Integer activityId);

    //缴费成功的成员
    boolean addPayment(PaymentVO paymentVO);

}
