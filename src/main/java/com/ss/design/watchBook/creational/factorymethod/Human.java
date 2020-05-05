package com.ss.design.watchBook.creational.factorymethod;

/**
 * Human
 *
 * 工厂方法：
 * 1.创建一个接口（一类商品）
 * 2.实现继承接口 （具体商品）
 * 3.创建一个工厂方法，根据条件来具体制造商品（new）
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

}
