package com.ss.design.pattern.structural.facade;

/**
 * QualifyService
 *
 * @author shisong
 * @date 2019/1/10
 */
public class QualifyService {

    public boolean isAvailable(PointGift pointGift) {
        System.out.println("校验" + pointGift.getName() + " 积分资格通过，库存通过");
        return true;
    }

}
