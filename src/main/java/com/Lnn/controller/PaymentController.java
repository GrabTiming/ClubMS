package com.Lnn.controller;

import com.Lnn.entity.Payment;
import com.Lnn.result.RestBean;
import com.Lnn.service.PaymentService;
import com.Lnn.vo.requestVO.UpdatePaymentVO;
import com.Lnn.vo.responseVO.PaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/update")
    public RestBean updatePayment(@RequestBody UpdatePaymentVO vo)
    {
        paymentService.update(vo);
        return RestBean.success(null,"缴费成功");
    }

}
