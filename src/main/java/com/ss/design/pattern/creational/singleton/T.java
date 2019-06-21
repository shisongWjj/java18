package com.ss.design.pattern.creational.singleton;

public class T implements Runnable {
    @Override
    public void run() {
        /* LazySingleton lazySingleton = LazySingleton.getInstatnce();*/
       /*ContainerSingleton.putInstance("object",new Object());
        Object lazySingleton = ContainerSingleton.getInstance("object");*/
        ThreadLocalInstance instance = ThreadLocalInstance.getInstance();
        System.out.println(Thread.currentThread().getName() + " :" + instance);
    }
}
