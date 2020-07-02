package com.ss.gupao.thread;

/**
 * SynchronizedDemo
 *
 * @author shisong
 * @date 2020/6/18
 */
public class SynchronizedDemo {

    static int count = 0;

    public static void incr(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) {
        for(int i = 0; i<1000;i++){
            new Thread(()->SynchronizedDemo.incr()).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("运行结果："+count);
    }

}
