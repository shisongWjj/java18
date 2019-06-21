package com.ss.design.pattern.structural.adapter.objectadapter;

/**
 * Adapter 适配者 实现目标 然后在类型创建一个被适配者对象，在实现的方法中，让被适配者对象调用其本身的方法
 *
 * @author shisong
 * @date 2019/1/14
 */
public class Adapter implements Target {

    Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
