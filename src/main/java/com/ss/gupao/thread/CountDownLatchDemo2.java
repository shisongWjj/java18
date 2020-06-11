package com.ss.gupao.thread;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchDemo2
 *
 * @author shisong
 * @date 2020/6/11
 */
public class CountDownLatchDemo2 {

    static CountDownLatch countDownLatch = new CountDownLatch(1);


    public static void main(String[] args) throws InterruptedException{
        for (int i = 0 ; i < 10 ; i++){
            new Thread(()->{
                try {
                    countDownLatch.await();
                    System.out.println(111111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(10000);

        countDownLatch.countDown();
    }

}
