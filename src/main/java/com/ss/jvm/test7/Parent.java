package com.ss.jvm.test7;

/**
 * Parent
 *
 * @author shisong
 * @date 2019/3/11
 */
public class Parent {

    public static int A = 1;

    static {
        A=2;
    }

    static class sub extends Parent{
        public static int B =A;
    }

    public static void main(String[] args) {
        System.out.println(sub.B);
    }

}
