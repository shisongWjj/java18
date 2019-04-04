package com.ss.juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  编写一个程序，开启 3 个线程，这三个线程的 ID 分别为
 A、 B、 C，每个线程将自己的 ID 在屏幕上打印 10 遍，要
 求输出的结果必须按顺序显示。
 如： ABCABCABC…… 依次递归
  升级版
 */
public class TestABCAlternate2 {

    public static void main(String[] args) {
        AlternateDemo2 ad2 = new AlternateDemo2();
        new  Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i<=10;i++){
                    ad2.LockA(i);
                }
            }
        }).start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i<=10;i++){
                    ad2.LockB(i);
                }
            }
        }).start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i<=10;i++){
                    ad2.LockC(i);
                }
            }
        }).start();
    }
}

class AlternateDemo2{

    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    private Integer number = 1;

    public void LockA(Integer time){
        lock.lock();

        try {
            if(!number.equals(1)){
                try {
                    conditionA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("第"+time+"次循环输出A");

            number = 2;
            conditionB.signal();
        }finally {
            lock.unlock();
        }
    }

    public void LockB(Integer time){
        lock.lock();

        try {
            if(!number.equals(2)){
                try {
                    conditionB.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("第"+time+"次循环输出B");

            number = 3;
            conditionC.signal();
        }finally {
            lock.unlock();
        }
    }

    public void LockC(Integer time){
        lock.lock();

        try {
            if(!number.equals(3)){
                try {
                    conditionC.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("第"+time+"次循环输出C");

            number = 1;
            conditionA.signal();
        }finally {
            lock.unlock();
        }
    }

}
