package com.ss.juc.gupao;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockDemo1
 *
 * @author shisong
 * @date 2020-05-30
 */
public class ReentrantLockDemo1 {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        int i = 1;
        new Thread(()->{
            incr(i);
        }).start();

    }

    static void incr(int i){
        //当主线程走到这里的时候，该线程已经抢到了锁，
        lock.lock();
        try {
             i++;
            decr(i);
             System.out.println(i);
        }finally {
            lock.unlock();
        }
    }

    static void decr(int i){
        //然后再走到这里，如果说，不是可重入锁的话，会发生什么？
        //死锁
        //但是看到结果，并没有死锁，所以证明了可重入
        lock.lock();
        try {
            i--;
            System.out.println(i);
        }finally {
            lock.unlock();
        }

    }
}