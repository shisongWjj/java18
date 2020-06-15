package com.ss.gupao.thread;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreDemo
 *
 * @author shisong
 * @date 2020/6/15
 */
public class SemaphoreDemo {

    static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        for(int i =0 ;i< 10;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+":抢到了车位");
                    Thread.sleep(1000);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+":释放了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },"Thread " + i).start();
        }
    }

}
