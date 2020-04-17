package com.ss.design.watchBook.structural.proxy;

/**
 * KindWoman
 * 1,创建一个接口
 * 2.代理类和被代理类 都实现这个接口
 * 3.代理类 有一个属性 接口对象，有参构造，操作方法的时候，实际是被代理类的调用
 *
 * @author shisong
 * @date 2020/4/15
 */
public interface KindWoman {

    /**
     * 取悦男人
     */
    void happyWithMan();

    /**
     * 抛媚眼
     */
    void eyesWithMan();

}
