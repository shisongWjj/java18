package com.ss.design.pattern.creational.singleton;

/**
 * 基于Threadlocal的单例模式，这里的单例是指线程单例，即同一个线程是单例的。
 * Threadlocal本身就是在同一个线程中，获取数据是同一个。
 * 通过测试类  我们可以看到，在同一个线程，获取到的对象是同一个。
 */
public class ThreadLocalInstance {

    private static final ThreadLocal<ThreadLocalInstance> threadLocalInstance = new ThreadLocal<ThreadLocalInstance>() {
        @Override
        protected ThreadLocalInstance initialValue() {
            return new ThreadLocalInstance();
        }
    };

    private ThreadLocalInstance() {

    }

    public static ThreadLocalInstance getInstance() {
        return threadLocalInstance.get();
    }

}
