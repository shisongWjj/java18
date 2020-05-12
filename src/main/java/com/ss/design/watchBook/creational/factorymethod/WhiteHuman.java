package com.ss.design.watchBook.creational.factorymethod;

/**
 * WhiteHuman
 *
 * @author shisong
 * @date 2020/4/20
 */
public class WhiteHuman implements Human{
    @Override
    public void talk() {
        System.out.println("白种人在说话。。。。。。");
    }

    @Override
    public void cry() {
        System.out.println("白种人在哭。。。。。。");
    }

    @Override
    public void laugh() {
        System.out.println("白种人在大笑。。。。。。");
    }
}
