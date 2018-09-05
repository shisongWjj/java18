package com.ss.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 当多个线程操作 i++时 ，可能当线程1执行到读或者改的时候  线程2也开启了 ，这时就会产生 多个线程返回同一个值
 * 原子性：具有不可分割的特性，即i++，这里三分3个步骤，要将这三个步骤看成一个整体，就满足了原子性。
 *
 * jdk1.5  提供了一个包 java.util.concurrent.atomic 用来解决原子性问题， 原子类中的参数一定是 具备内存可见的 即 参数都是有volatile修饰的，同时要满足CAS算法（详见TestCompareAndSwap）
 *
 *
 * i++的原子性问题:i++ 的操作实际上分为三个步骤“读-改-写”
 * int i = 10;
 i = i++;
 System.out.println(i); //10

 i= i++;==>
 int temp= i;
 i=i+1;
 i=temp;

 */
public class TestAtomicDemo {

    public static void main(String[] args) {
        /*int i = 10;
        i = i++;
        System.out.println(i);*/
        AtomicDemo a1 = new AtomicDemo();
        for(int i= 0;i<100;i++){
            new Thread(a1).start();
        }
    }
}

class AtomicDemo implements Runnable{

    private AtomicInteger num;

    public int getNum(){
        return num.getAndIncrement();
    }

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

        System.out.println(getNum());
    }
}
