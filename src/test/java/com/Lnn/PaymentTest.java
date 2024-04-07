package com.Lnn;


import com.Lnn.entity.PaymentVO;
import com.Lnn.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PaymentTest {

    /**
     * 测试缴费是否插入成功
     */
    @Autowired
    private PaymentService paymentService;
    @Test
    public void PaymentInsertTest()
    {
        //用户ljt 在活动 推歌活动中 缴费5元
        paymentService.addPayment(5,5,5.0);
    }

    //活动的缴费总额
    @Test
    public void PaymentCount()
    {
        System.out.println(paymentService.getSumByActivityId(5));
    }

    //根据用户id查询缴费信息
    @Test
    public void getByUserId()
    {
        List<PaymentVO> payments = paymentService.getByUserId(5);

        System.out.println(payments.toString());
    }

}
