package com.ss.design.pattern.structural.facade;

/**
 * GiftExchangeService
 *
 * @author shisong
 * @date 2019/1/10
 */
public class GiftExchangeService {

    private PointPaymentService pointPaymentService = new PointPaymentService();
    private QualifyService qualifyService = new QualifyService();
    private ShippingService shippingService = new ShippingService();

    public void giftExchange(PointGift pointGift) {
        if (qualifyService.isAvailable(pointGift)) {
            //积分验证通过
            if (pointPaymentService.pay(pointGift)) {
                //支付通过
                String s = shippingService.shipGift(pointGift);
                System.out.println("下单成功，订单号：" + s);
            }
        }
    }

}
