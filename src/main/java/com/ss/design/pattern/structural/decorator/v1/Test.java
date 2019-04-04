package com.ss.design.pattern.structural.decorator.v1;

/**
 * Test
 *
 * @author shisong
 * @date 2019/1/11
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 煎饼 销售价格：8
         煎饼 加一个鸡蛋 销售价格：9
         煎饼 加一个鸡蛋 加一个香肠 销售价格：11
         用单继承 如果有客人需要2个鸡蛋，目前的功能就没办法实现，所以 这里引入装饰者模式，请看V2
         装饰者模式 四个角色：
         抽象的被装饰者
         实际的被装饰者
         抽象的装饰物
         实际的装饰物
         */
        Battercake battercake = new Battercake();
        System.out.println(battercake.getDesc() + " 销售价格："+battercake.cost());

        BattercakeWithEgg battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getDesc() + " 销售价格："+battercakeWithEgg.cost());

        BattercakeWithEggSausage battercakeWithEggSausage = new BattercakeWithEggSausage();
        System.out.println(battercakeWithEggSausage.getDesc() + " 销售价格："+battercakeWithEggSausage.cost());
    }

}
