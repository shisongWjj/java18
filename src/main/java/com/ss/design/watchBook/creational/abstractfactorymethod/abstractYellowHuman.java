package com.ss.design.watchBook.creational.abstractfactorymethod;

public abstract class abstractYellowHuman implements Human{

    @Override
    public void talk() {
        System.out.println("黄种人在说话。。。。。。");
    }

    @Override
    public void cry() {
        System.out.println("黄种人在哭。。。。。。");
    }

    @Override
    public void laugh() {
        System.out.println("黄种人在大笑。。。。。。");
    }

}
