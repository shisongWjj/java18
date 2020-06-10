package com.ss.gupao.thread;

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
        //------------添加元素--------------
        //add 元素添加成功返回true,失败抛出异常，阻塞式添加元素
        //如果元素个数满了，则返回抛出异常
        blockingQueue.add("11");

        //offer 元素添加成功返回true,失败返回fasle，阻塞式添加元素
        //如果元素个数满了，则返回false
        blockingQueue.offer("22");

        //offer 没有返回值，阻塞式添加元素，
        //如果元素个数满了 则当前线程await,让给其他线程去执行
        blockingQueue.put("33");
        //------------添加元素--------------

        //------------取出元素--------------
        blockingQueue.poll();
        blockingQueue.remove();
        blockingQueue.take();
        //------------取出元素--------------
    }

}
