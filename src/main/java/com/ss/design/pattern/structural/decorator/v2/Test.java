package com.ss.design.pattern.structural.decorator.v2;

/**
 * Test
 *
 * @author shisong
 * @date 2019/1/11
 */
public class Test {

    public static void main(String[] args) {
        //煎饼 加一个鸡蛋 加一个鸡蛋 加一个香肠 销售价格：12
        ABattercake aBattercake;
        aBattercake = new Battercake();
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new SausageDecorator(aBattercake);
        System.out.println(aBattercake.getDesc() + " 销售价格："+aBattercake.cost());
    }

}
