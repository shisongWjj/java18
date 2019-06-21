package com.ss.design.pattern.structural.decorator.v2;

/**
 * Battercake
 *
 * @author shisong
 * @date 2019/1/11
 */
public class Battercake extends ABattercake {
    @Override
    public String getDesc() {
        return "煎饼";
    }

    @Override
    public int cost() {
        return 8;
    }
}
