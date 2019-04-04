package com.ss.design.pattern.structural.facade;

/**
 * Test
 *
 * @author shisong
 * @date 2019/1/10
 */
public class Test {

    public static void main(String[] args) {
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        PointGift pointGift = new PointGift();
        pointGift.setName("T-shift");
        giftExchangeService.giftExchange(pointGift);
    }

}
