package com.ss.gupao.thread;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchDemo1
 *
 * @author shisong
 * @date 2020/6/11
 */
public class CountDownLatchDemo1 {

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException{

        new Thread(()->{
            System.out.println("1111111");
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            System.out.println("1111111");
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            System.out.println("1111111");
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();
    }
}
