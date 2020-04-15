package com.ss.design.watchBook.structural.strategy;

/**
 * BackDoorStrategyService
 *
 * @author shisong
 * @date 2020/4/15
 */
public class BackDoorStrategyService implements IStrategy{
    @Override
    public void operate() {
        System.out.println("锦囊妙计1：走后门------------");
    }
}
