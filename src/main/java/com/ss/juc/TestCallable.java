package com.ss.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * callable ：实现线程的第三种方式；相较于runnable，多了返回值，还有可以抛出异常
 */
public class TestCallable {

    public static void main(String[] args) {

        CallableDemo cd = new CallableDemo();
        //开启线程是，入参不是Callable，而是futrueTask,，可以用来接收callable的返回值
        //而是futrueTask 构造方法  可以传入 Runnable和Callable
        FutureTask<Integer> futureTask = new FutureTask<Integer>(cd);
        //这块不走完，下面不会走，有闭锁的功能
        new Thread(futureTask).start();

        try {
            Integer sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
    }
}


class CallableDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}

/*class CalllableDemo implements Runnable{

    @Override
    public void run() {

    }
}*/
