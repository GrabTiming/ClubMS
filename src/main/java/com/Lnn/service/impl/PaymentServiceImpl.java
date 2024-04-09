package com.Lnn.service.impl;

import com.Lnn.entity.PaymentVO;
import com.Lnn.entity.User;
import com.Lnn.mapper.PaymentMapper;
import com.Lnn.mapper.UserMapper;
import com.Lnn.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * (Payment)表服务实现类
 *
 * @author makejava
 * @since 2024-04-06 19:17:23
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;


    @Override
    public List<PaymentVO> getByUserId(Integer userId) {

        return paymentMapper.getByUserId(userId);

    }
    @Override
    public List<PaymentVO> getByActivityId(Integer activityId) {
        return paymentMapper.getByActivityId(activityId);
    }

    @Override
    public Double getSumByActivityId(Integer activityId) {
        return paymentMapper.getSumByActivityId(activityId);
    }

    @Override
    public boolean addPayment(Integer userId, Integer activityId, Double cost) {

        return paymentMapper.insert(userId, activityId, cost) > 0;

    }
}
