package com.ss.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步锁 lock
 *
 * 用户解决多线程的安全问题 有三种方法
 * synchronized:
 * 1.同步方法
 *
 * 2.同步代码块
 *
 *  JDK1.5以后 juc提供可一个lock
 *  3.同步锁：lock
 *      注意：只是一个显示所，需要通过lock()方法 上锁  ，必须通过unlock()方法进行解锁
 */
public class TestLock {


    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket,"1号窗口").start();
        new Thread(ticket,"2号窗口").start();
        new Thread(ticket,"3号窗口").start();
    }

}

class Ticket implements Runnable{

    private  Integer tick = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){

            //上锁
            lock.lock();

            try {
                if(tick>0){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                    }

                    System.out.println(Thread.currentThread().getName()+" 完成售票，余票为："+ --tick);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}


