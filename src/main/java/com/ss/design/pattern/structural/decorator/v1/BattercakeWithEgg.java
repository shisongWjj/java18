package com.ss.design.pattern.structural.decorator.v1;

/**
 * BattercakeWithEgg
 *
 * @author shisong
 * @date 2019/1/11
 */
public class BattercakeWithEgg extends Battercake {

    @Override
    public String getDesc() {
        return super.getDesc() + " 加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
