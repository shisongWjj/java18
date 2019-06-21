package com.ss.jvm.test6;

/**
 * Parent
 *
 * @author shisong
 * @date 2019/3/9
 */
public class Parent {

    static {
        System.out.println("父类的初始化");
    }

    public static Integer num = 10;
}
