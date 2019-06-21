package com.ss.jvm.test10;

/**
 * Main
 *
 * @author shisong
 * @date 2019/3/26
 */
public class Main {

    static class Parent {
    }

    static class Child1 extends Parent {
    }

    static class Child2 extends Parent {
    }

    public void sayHello(Child1 c1) {
        System.out.println("c1 call");
    }

    public void sayHello(Child2 c2) {
        System.out.println("c2 call");
    }

    public void sayHello(Parent p) {
        System.out.println("p call");
    }

    public static void main(String[] args) {
        Parent p1 = new Child1();

        Parent p2 = new Child2();

        Main m = new Main();
        m.sayHello(p1);
        m.sayHello(p2);


        Parent p = new Parent();
        p = new Child1();
        m.sayHello((Child1) p);

    }

}
