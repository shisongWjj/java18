package com.ss.juc.gupao;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockDemo
 *
 * @author shisong
 * @date 2020/5/28
 */
public class ReentrantLockDemo {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Demo(),"Thread_01");
        t1.start();

        Thread t2 = new Thread(new Demo(),"Thread_02");
        t2.start();

    }

    static class Demo implements Runnable{
        @Override
        public void run() {
            //阻塞线程
            lock.lock();
            try {
                //do something
                Thread.sleep(1000L);
                System.out.println("线程"+Thread.currentThread().getName());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

}
