package com.ss.design.pattern.structural.facade;

/**
 * ShippingService
 *
 * @author shisong
 * @date 2019/1/10
 */
public class ShippingService {

    public String shipGift(PointGift pointGift) {
        //物流系统的对接逻辑
        System.out.println(pointGift.getName() + "物流跟踪中");
        String shippingOrderNo = "666";
        return shippingOrderNo;
    }
}
