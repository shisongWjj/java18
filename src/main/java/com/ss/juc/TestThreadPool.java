package com.ss.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 之前 每次开启一个新的线程时，都是new Thread().start;这样都会在创建线程，和销毁线程时，产生额外的开销 ，所以jdk1.5后 提供了线程池的概念
 *
 * 一.线程池： 类似于数据库连接池，提供了一个线程队列，队列中保存着所有等待状态的线程。避免了创建与销毁产生的额外开销，提供了响应的速度。
 *
 * 二.线程池的体系结构：
 * java.util.concurrent.Executor: 负责线程的使用与调度的根接口
 *      |-- ExecutorService 子接口:线程池的主要接口
 *          |-- ThreadPoolExecutor 线程池的主要接口
 *          |-- ScheduledExecutorService 子接口：负责线程的调度
 *              |-- ScheduledThreadPoolExecutor ：继承了ThreadPoolExecutor，并且实现了ScheduledExecutorService
 *
 * 三.工具类Executors
 *      Executors.newCachedThreadPool()：无界线程池，可以进行自动线程回收 线程池的数量不固定，可以根据需求自动的更改数量
 *      Executors.newFixedThreadPool(int)：固定大小线程池
 *      Executors.newSingleThreadExecutor()：单个后台线程
 *ScheduledExecutorService newScheduledThreadPool():创建固定带下的线程，可以延迟或定时的执行任务
 *
 */
public class TestThreadPool {

    public static void main(String[] args) throws Exception{
        //1.创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

        ThreadPoolDemo tpd = new ThreadPoolDemo();

        List<Future<Integer>> futures = new ArrayList<>();
        /**
         * callable
         */
        for(int i=0;i<10;i++){
            Future<Integer> future = pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Integer sum = 0;
                    for (int i=0;i<=100;i++){
                        sum+=i;
                    }
                    return sum;
                }
            });
            futures.add(future);
        }

        for (Future<Integer> future : futures) {
            System.out.println(future.get());
        }

        pool.shutdown();


        /*
        Runnable
        //2.为线程池中的线程分配任务
        *//**
         * pool-1-thread-1:0
         pool-1-thread-1:1
         pool-1-thread-1:2
         pool-1-thread-1:3
         *//*
        *//*pool.submit(tpd);*//*

        //开启10个线程
        *//**
         * pool-1-thread-1:100
         pool-1-thread-5:82
         pool-1-thread-2:66
         pool-1-thread-4:92
         pool-1-thread-3:91
         *//*
        for(int i = 0; i<10;i++){
            pool.submit(tpd);
        }

        //3.关闭线程池
        pool.shutdown();*/

       /* new Thread(tpd).start();
        new Thread(tpd).start();*/
    }
}

class ThreadPoolDemo implements Runnable{

    private int i = 0;

    @Override
    public void run() {
        while (i<=100){
            System.out.println(Thread.currentThread().getName()+":"+i++);
        }
    }
}

