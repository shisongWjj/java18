package com.ss.design.watchBook.structural.proxy;

/**
 * PanJinLian 被代理类
 *
 * @author shisong
 * @date 2020/4/15
 */
public class PanJinLian implements KindWoman{
    @Override
    public void happyWithMan() {
        System.out.println("潘金莲在取悦男人。。。。。。。。。");
    }

    @Override
    public void eyesWithMan() {
        System.out.println("潘金莲在抛媚眼。。。。。。。。。");
    }
}
