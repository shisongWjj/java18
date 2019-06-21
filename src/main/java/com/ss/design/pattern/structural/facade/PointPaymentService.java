package com.ss.design.pattern.structural.facade;

/**
 * PointPaymentService
 *
 * @author shisong
 * @date 2019/1/10
 */
public class PointPaymentService {

    public boolean pay(PointGift pointGift) {
        System.out.println("支付" + pointGift.getName() + " 积分成功");
        return true;
    }
}
