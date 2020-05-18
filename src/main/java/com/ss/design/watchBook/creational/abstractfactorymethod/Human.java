package com.ss.design.watchBook.creational.abstractfactorymethod;

/**
 * Human
 *
 * 抽象工厂方法：
 * 1.创建一个接口（一类商品）
 * 2.实现抽象类继承接口 （产品等级）
 * 3.
 *
 *
 * @author shisong
 * @date 2020/4/20
 */
public interface Human {

    /**
     * 说话
     */
    void talk();

    /**
     * 哭
     */
    void cry();

    /**
     * 笑
     */
    void laugh();

    /**
     * 性别
     */
    void sex();

}
