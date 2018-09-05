package com.ss.juc;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch:闭锁  在完成某些运算时，只有当其他线程的运算都完成时，当前线程的运算才会继续执行
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        CountDownLatchDemo cd = new CountDownLatchDemo(latch);
        long start = System.currentTimeMillis();

        for(int i=0;i<5;i++){
            new Thread(cd).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
        }
        long end = System.currentTimeMillis();

        System.out.println("共消耗："+(end-start));
    }

}

class CountDownLatchDemo implements Runnable{
    private CountDownLatch latch;

    public CountDownLatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {

        synchronized(this){
            try {
                for(int i =0 ; i<50000;i++){
                    if(i%2==0){
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();
            }
        }


    }
}
