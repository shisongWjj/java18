package com.ss.juc;

import java.util.Random;
import java.util.concurrent.*;

public class TestScheduleExecutorService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.创建线程池
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        //2.为线程池分配任务
        for (int i = 0; i < 10; i++) {
            ScheduledFuture<Integer> schedule = pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + " : " + num);
                    return num;
                }
            }, 1, TimeUnit.SECONDS);
            System.out.println(schedule.get());
        }
        //3.关闭线程池
        pool.shutdown();
    }
}
