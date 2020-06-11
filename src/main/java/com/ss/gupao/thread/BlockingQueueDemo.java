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

        //------------移除元素，并返回被移除元素的值--------------
        //remove 获取元素，取到了就返回元素，没有就抛出异常 阻塞式获取元素
        //如果元素个数为0，则抛出异常
        blockingQueue.remove();

        //poll 获取元素，取到了就返回元素，没有就返回null 阻塞式获取元素
        //如果元素个数为0，则返回null
        blockingQueue.poll();

        //获取元素，取到了就返回元素，没有就阻塞
        //如果没有元素了，则当前线程await,让给其他线程去执行
        blockingQueue.take();
        //------------移除元素，并返回被移除元素的值--------------
    }

}
