package com.ss.design.pattern.creational.singleton;

public class T implements Runnable{
    @Override
    public void run() {
        LazySingleton lazySingleton = LazySingleton.getInstatnce();
        System.out.println(Thread.currentThread().getName() +" :"+lazySingleton);
    }
}
