package com.Lnn.controller;

import com.Lnn.entity.Payment;
import com.Lnn.result.RestBean;
import com.Lnn.service.PaymentService;
import com.Lnn.vo.responseVO.PaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/userPayment/{id}")
    public RestBean<List<PaymentVO>> getPaymentByUserId(@PathVariable("id") Integer userId)
    {
        return RestBean.success(paymentService.getPaymentByUserId(userId));
    }


    @GetMapping("/activityPayment/{id}")
    public RestBean<List<PaymentVO>> getPaymentByActivityId(@PathVariable("id") Integer activityId)
    {
        return RestBean.success(paymentService.getPaymentByActivityId(activityId));
    }
}
