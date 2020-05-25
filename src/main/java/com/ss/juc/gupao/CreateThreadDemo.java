package com.ss.juc.gupao;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThreadDemo {

    public static void main(String[] args) {

        //继承Thread
        CreateThreadDemo1 t1 = new CreateThreadDemo1();
        t1.start();

        //实现runnable
        CreateThreadDemo2 t2 = new CreateThreadDemo2();
        new Thread(t2).start();

        //实现callable
        CreateThreadDemo3 t3 = new CreateThreadDemo3();
        FutureTask<String> futureTask = new FutureTask(t3);
        Thread thread3 = new Thread(futureTask);
        thread3.start();
        try {
            String o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Thread.currentThread().stop();

        Thread.currentThread().interrupt();

    }


    //方式1
    static class CreateThreadDemo1 extends Thread{
        @Override
        public void run() {
            System.out.println("CreateThreadDemo1 start......");
        }
    }

    //方式2
    static class CreateThreadDemo2 implements Runnable{

        @Override
        public void run() {
            System.out.println("CreateThreadDemo2 start......");
        }
    }

    static class CreateThreadDemo3 implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("CreateThreadDemo3 start......");
            return "OK";
        }
    }

}
