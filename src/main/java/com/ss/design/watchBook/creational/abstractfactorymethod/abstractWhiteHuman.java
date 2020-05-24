package com.ss.design.watchBook.creational.abstractfactorymethod;

public abstract class abstractWhiteHuman implements Human{
    
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
