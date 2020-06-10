package com.ss.gupao.thread;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {



    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Queue<String> queue = new PriorityQueue();
        int maxSize = 10;
        Thread t1 = new Thread(new ProviderLockDemo(queue,maxSize,lock,condition));
        Thread t2 = new Thread(new ConsumerLockDemo(queue,maxSize,lock,condition));

        t1.start();
        t2.start();
    }

    /*public static void main(String[] args) {
        *//* int i = 0;
        while (true){
            i++;
            lock.lock();
            try {
                if(i == 10){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                condition.signal();

            }finally {
                lock.unlock();
            }
        }*//*
    }*/

}
