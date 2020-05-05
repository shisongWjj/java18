package com.ss.design.watchBook.structural.proxy;

/**
 * JiaShi
 *
 * @author shisong
 * @date 2020/4/17
 */
public class JiaShi implements KindWoman{
    @Override
    public void happyWithMan() {
        System.out.println("贾氏在取悦男人。。。。。。。。。");
    }

    @Override
    public void eyesWithMan() {
        System.out.println("贾氏在抛媚眼。。。。。。。。。");
    }
}
