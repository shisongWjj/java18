package com.ss.juc;

/**
 * 线程八所：以下代码 看看输出"one" "two"的顺序：
 * 1.两个同步方法，分开开启2个线程，打印： one two
 * 2.在one()方法中 睡上3秒，打印：one two
 * 3.再加一个方法three，不加同步锁，打印：three one two
 * 4.注释掉three(),在创建一个number对象，分别开启线程，打印：two one
 * 5.将线程改为同一个对象调用，并将one()改为静态方法，打印：two one
 * 6.将两个方法都改为静态方法，打印：one two
 * 7.由两个对象分别 开启2个线程，打印:one two
 * 8.将方法two 改为 非静态，打印：two one
 * <p>
 * 结论：线程八锁的关键：
 * 1.非静态方法的锁 默认为 this , 静态方法的锁 默认为对应的class 实例
 * 2.某一个时刻内，只能有一个线程持有锁，无论几个方法。
 */
public class TestThread8Monitor {

    public static void main(String[] args) {
        Number number = new Number();
        Number number1 = new Number();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number.one();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //number.two();
                number1.two();
            }
        }).start();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                number.three();
            }
        }).start();*/

    }
}

class Number {

    public static synchronized void one() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public synchronized void two() {
        System.out.println("two");
    }

    public void three() {
        System.out.println("three");
    }

}

