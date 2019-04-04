package com.ss.design.pattern.structural.adapter.classadapter;

/**
 * Adapter 适配者 继承被被适配者 实现 目标
 * 然后在重写的方法中 调用被适配者的方法
 *
 * @author shisong
 * @date 2019/1/14
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        super.adapteeRequest();
    }
}
