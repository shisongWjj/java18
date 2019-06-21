package com.ss.design.pattern.creational.singleton;

public class LazyDoubleCheckSingleton {
    //创建静态对象，赋值为null
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    //私有化构造器
    private LazyDoubleCheckSingleton() {
    }

    //创建一个静态方法，判断，当对象为null时，创建对象
    public static LazyDoubleCheckSingleton getInstatnce() {
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazyDoubleCheckSingleton == null) {
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                    //1.分配内存给这个对象
                    //2.初始化对象
                    //3.设置lazyDoubleCheckSingleton 指向刚刚分配的内存地址。
                    //在java内有这样一个协议intra-thread semantics 保证重排序不会改变单线程内的程序执行结果。
                    //换句话说，intra-thread semantics 允许那些在单线程内，不会改变单线程程序执行结果的重排序
                    //即2，3可以互换位置
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
