package com.ss.design.watchBook.creational.factorymethod;

/**
 * BlackHuman
 *
 * @author shisong
 * @date 2020/4/20
 */
public class BlackHuman implements Human{
    @Override
    public void talk() {
        System.out.println("黑种人在说话。。。。。。");
    }

    @Override
    public void cry() {
        System.out.println("黑种人在哭。。。。。。");
    }

    @Override
    public void laugh() {
        System.out.println("黑种人在大笑。。。。。。");
    }
}
