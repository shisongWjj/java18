package com.ss.juc;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    static volatile AtomicInteger i =new AtomicInteger(1);

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        pool.submit(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                i = i+1;
            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                i = i+1;
            }
        });

        pool.submit(new Callable<AtomicInteger>() {
            @Override
            public AtomicInteger call() throws Exception {
                i.getAndDecrement();
                return i;
            }
        });
        Future<AtomicInteger> submit = pool.submit(new Callable<AtomicInteger>() {
            @Override
            public AtomicInteger call() throws Exception {
                i.getAndDecrement();
                return i;
            }
        });
        try {
            AtomicInteger atomicInteger = submit.get();
            System.out.println(atomicInteger);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
