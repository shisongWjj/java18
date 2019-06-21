package com.ss.jvm.test7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * DemoThread
 *
 * @author shisong
 * @date 2019/3/11
 */
public class DemoThread {

    static class Hello {
        static {
            System.out.println(Thread.currentThread().getName() + "init.......");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        void sayHello() {
            System.out.println("hahhahahaahahahhaahahahaha");
        }

    }

    /*public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "start......");
                Hello hello = new Hello();
                hello.sayHello();
                System.out.println(Thread.currentThread().getName() + "end......");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "start......");
                Hello hello = new Hello();
                hello.sayHello();
                System.out.println(Thread.currentThread().getName() + "end......");
            }
        }).start();
    }*/

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        int i = 0;
        while (i++ < 20) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "start......");
                    Hello hello = new Hello();
                    System.out.println(Thread.currentThread().getName() + "end......");
                }
            });
        }
    }

}
