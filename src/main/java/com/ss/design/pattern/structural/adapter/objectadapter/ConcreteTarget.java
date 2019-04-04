package com.ss.design.pattern.structural.adapter.objectadapter;


/**
 * ConcreteTarget 目标接口的一个实现
 *
 * @author shisong
 * @date 2019/1/14
 */
public class ConcreteTarget implements Target{
    @Override
    public void request() {
        System.out.println("ConcreteTarget的方法");
    }
}
