package com.ss.gupao.thread;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ProviderLockDemo implements Runnable {

    private Queue<String> msg;

    private Integer maxSize;

    private Lock lock;

    private Condition condition;

    public ProviderLockDemo(Queue<String> msg, Integer maxSize, Lock lock, Condition condition) {
        this.msg = msg;
        this.maxSize = maxSize;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            i++;
            lock.lock();
            try {
                //当生产者生产到最大值时，暂定生产
                if(msg.size() == maxSize){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                msg.add("产品"+i);
                System.out.println("生产者生产了:产品"+i);
                //只要生产了，有东西了，就可以唤醒消费者了
                condition.signal();
            } finally {
                lock.unlock();
            }
        }

    }
}
