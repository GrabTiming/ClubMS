package com.Lnn.service.impl;

import com.Lnn.entity.Payment;
import com.Lnn.mapper.PaymentMapper;
import com.Lnn.service.PaymentService;
import com.Lnn.vo.requestVO.UpdatePaymentVO;
import com.Lnn.vo.responseVO.PaymentVO;
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
    public Integer addPayment(Payment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public List<PaymentVO> getPaymentByUserId(Integer userId) {
        return paymentMapper.getPaymentByUserId(userId);
    }

    @Override
    public List<PaymentVO> getPaymentByActivityId(Integer activityId) {
        return paymentMapper.getPaymentByActivityId(activityId);
    }

    @Override
    public void update(UpdatePaymentVO vo) {
         paymentMapper.update(vo);
    }
}
