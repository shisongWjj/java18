package com.ss.juc.gupao;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * BlockingQueueDemo
 *
 * @author shisong
 * @date 2020-06-06
 */
public class BlockingQueueDemo {

    static BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();


    public static void main(String[] args) throws InterruptedException{
        blockingQueue.add("11");
        blockingQueue.offer("22");
        blockingQueue.put("33");
        blockingQueue.poll();
        blockingQueue.remove();
        blockingQueue.take();

    }

}
