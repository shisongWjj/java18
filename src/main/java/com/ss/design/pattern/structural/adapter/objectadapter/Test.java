package com.ss.design.pattern.structural.adapter.objectadapter;



/**
 * 适配器分为 类适配器 和 对象适配器
 * 这里讲的是对象适配器  组合
 *
 * 当继承和组合都可以的情况下，优先选择组合
 *
 * @author shisong
 * @date 2019/1/14
 */
public class Test {

    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }

}
