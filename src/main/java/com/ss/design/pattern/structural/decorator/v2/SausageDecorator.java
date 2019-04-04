package com.ss.design.pattern.structural.decorator.v2;

/**
 * SausageDecorator
 *
 * @author shisong
 * @date 2019/1/11
 */
public class SausageDecorator extends AbstractDecorator{
    public SausageDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + " 加一个香肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
