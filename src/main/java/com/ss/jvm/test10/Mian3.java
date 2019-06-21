package com.ss.jvm.test10;

/**
 * Mian3
 *
 * @author shisong
 * @date 2019/3/26
 */
public class Mian3 {

    static class Parent {
        public void sayHello() {
            System.out.println("parent");
        }
    }

    static class Child1 extends Parent {
        @Override
        public void sayHello() {
            System.out.println("child1");
        }
    }

    static class Child2 extends Parent {
        @Override
        public void sayHello() {
            System.out.println("child2");
        }
    }

    public static void main(String[] args) {
        Parent p1 = new Child1();
        Parent p2 = new Child2();

        p1.sayHello();
        p2.sayHello();
    }

}
