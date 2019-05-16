package com.ss.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  编写一个程序，开启 3 个线程，这三个线程的 ID 分别为
 A、 B、 C，每个线程将自己的 ID 在屏幕上打印 10 遍，要
 求输出的结果必须按顺序显示。
 如： ABCABCABC…… 依次递归
 */
public class TestABCAlternate {

    public static void main(String[] args) {
        AlternateDeom ad = new AlternateDeom();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i<=10;i++){
                    ad.LockA();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i<=10;i++){
                    ad.LockB();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i<=10;i++){
                    ad.LockC();
                }
            }
        }).start();

    }
}

class AlternateDeom{
    //创建锁对象
    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    Integer number = 1;

    public void LockA(){
        lock.lock();

        try {
            if(!number.equals(1)){
                //当不等于1的时候，锁住 A
                try {
                    conditionA.await();
                } catch (InterruptedException e) {
                }
            }

            //输出A
            System.out.print("A");

            number =2;
            //唤醒B
            conditionB.signal();

        }finally {
            lock.unlock();
        }
    }

    public void LockB(){
        lock.lock();

        try {
            if(!number.equals(2)){
                //当不等于1的时候，锁住 B
                try {
                    conditionB.await();
                } catch (InterruptedException e) {
                }
            }

            //输出B
            System.out.print("B");

            number =3;
            //唤醒C
            conditionC.signal();

        }finally {
            lock.unlock();
        }
    }

    public void LockC(){
        lock.lock();

        try {
            if(!number.equals(3)){
                //当不等于1的时候，锁住 B
                try {
                    conditionC.await();
                } catch (InterruptedException e) {
                }
            }

            //输出B
            System.out.print("C");

            number =1;
            //唤醒C
            conditionA.signal();

        }finally {
            lock.unlock();
        }
    }


}