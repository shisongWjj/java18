package com.ss.juc.gupao;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * InterrupteDemo
 *
 * @author shisong
 * @date 2020/5/26
 */
public class InterrupteDemo {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
       /* try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        LockSupport.park();
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println(Thread.currentThread().isInterrupted());
        LockSupport.park();
        System.out.println(Thread.currentThread().isInterrupted());
    }


}
