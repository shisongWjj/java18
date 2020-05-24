package com.ss.design.watchBook.creational.abstractfactorymethod;

public abstract class abstractBlackHuman implements Human{
    
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
