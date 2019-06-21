package com.ss.design.pattern.structural.decorator.v2;

/**
 * EggDecorator
 *
 * @author shisong
 * @date 2019/1/11
 */
public class EggDecorator extends AbstractDecorator {
    public EggDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + " 加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
