package com.ss.jvm.test7;

/**
 * StaticTest
 *
 * @author shisong
 * @date 2019/3/11
 */
public class StaticTest {

    static int i = 1;

    static {
        i = 0;
        System.out.println(i);
    }
    // clinit 收集的顺序是顺序收集（从上至下）的。
    //static int i = 1;clinit 在静态语句块中只能访问定义在静态语句块之前的变量，定义在它之后的变量，只能赋值，不能访问
}
