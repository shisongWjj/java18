package com.ss.juc.gupao;

import java.util.concurrent.TimeUnit;

/**
 * ThreadDemo
 *
 * @author shisong
 * @date 2020-05-24
 */
public class ThreadDemo {

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread_Status_01").start();

        new Thread(()->{
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread_Status_02").start();

        BlockedThreadDemo t1 = new BlockedThreadDemo();
        t1.setName("Block_Thread_01");
        t1.start();
        BlockedThreadDemo t2 = new BlockedThreadDemo();
        t2.setName("Block_Thread_01");
        t2.start();

    }

    static class BlockedThreadDemo extends Thread{
        @Override
        public void run() {
            synchronized (this){
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
