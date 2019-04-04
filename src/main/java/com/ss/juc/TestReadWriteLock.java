package com.ss.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁：
 * 写写，读写 互斥
 *
 * 读读 不互斥
 */
public class TestReadWriteLock {

    public static void main(String[] args) {
        ReadWriteLockDemo rw = new ReadWriteLockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                rw.set((int) (Math.random()*101));
            }
        }).start();

        for(int i=0 ;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rw.get();
                }
            }).start();
        }
    }
}

class ReadWriteLockDemo{

    private Integer number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get(){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+":"+number);
        }finally {
            lock.readLock().unlock();
        }
    }

    public void set(Integer number){
        lock.writeLock().lock();
        try {
            System.out.println("write:");
            System.out.println(number);
            this.number = number;
        }finally {
            lock.writeLock().unlock();
        }
    }

}


