package com.ss.jvm.test6;

/**
 * Child
 *
 * @author shisong
 * @date 2019/3/9
 */
public class Child extends Parent {

    static {
        System.out.println("子类的初始化");
    }

    public static  int num = 12;

    public static final int a = 4;//这个不会被加载

    //public static final Integer a = 4;//这个会被加载


    public static void main(String[] args) {

    }

}
