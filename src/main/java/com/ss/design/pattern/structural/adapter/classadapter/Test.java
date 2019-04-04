package com.ss.design.pattern.structural.adapter.classadapter;

/**
 * 适配器分为 类适配器 和 对象适配器
 * 这里讲的是类适配器 继承
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
