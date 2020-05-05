package com.ss.design.watchBook.structural.strategy;

/**
 * GivenGreenLightStrategyService
 *
 * @author shisong
 * @date 2020/4/15
 */
public class GivenGreenLightStrategyService implements IStrategy{
    @Override
    public void operate() {
        System.out.println("锦囊妙计2：开绿灯------------");
    }
}
