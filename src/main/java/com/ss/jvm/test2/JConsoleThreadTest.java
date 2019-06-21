package com.ss.jvm.test2;

import java.util.Scanner;

/**
 * JConsoleThreadTest
 *
 * @author shisong
 * @date 2019/1/31
 */
public class JConsoleThreadTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.next();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        }, "while true").start();

        sc.next();

        Object o1 = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1) {
                    try {
                        o1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "wait").start();

    }

}
