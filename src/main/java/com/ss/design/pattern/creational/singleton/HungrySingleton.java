package com.ss.design.pattern.creational.singleton;

import java.io.Serializable;

/**
 * 饿汉式 ： 程序一启动就完成初始化
 * //1.静态初始化类
 * //2.私有化构造函数
 * //3.创建一个静态方法，直接返回对象
 */
public class HungrySingleton implements Serializable, Cloneable {

    //方式一：
    //private final static HungrySingleton hungrySingleton = new HungrySingleton();
    //方式二： 两种方式一样的
    private final static HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    private HungrySingleton() {
        if (hungrySingleton != null) {
            throw new RuntimeException("单例模式不能创建两个实例");
        }
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    private Object readResolve() {
        return hungrySingleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
