package com.ss.jvm.test11;

/**
 * Demo
 *
 * @author shisong
 * @date 2019/3/28
 */
public class Demo {

    private final int b;

    //被final修饰的变量，可以在构造方法中进行赋值
    public Demo(){
//        b=10;
    }


    //当在代码块中给被final修饰的变量赋值后，构造方法中报错了
    //那么也就说明代码块优先于构造方法执行的
    {
        b=20;
    }

    //在静态代码块中，给被final修饰的变量赋值后，直接保存
    //因为 static代码块在类加载的过程中取执行的
    static {
//        b=10;
    }


}
