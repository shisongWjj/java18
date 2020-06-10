package com.ss.gupao.thread;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConsumerLockDemo implements Runnable{

    private Queue<String> msg;

    private Integer maxSize;

    private Lock lock;

    private Condition condition;

    public ConsumerLockDemo(Queue<String> msg, Integer maxSize, Lock lock, Condition condition) {
        this.msg = msg;
        this.maxSize = maxSize;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if(msg.isEmpty()){
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
                System.out.println("消费者消费了："+msg.remove());
                condition.signal();

            }finally {
                lock.unlock();
            }
        }
    }
}
