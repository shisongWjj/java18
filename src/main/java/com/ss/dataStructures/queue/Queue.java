package com.ss.dataStructures.queue;

/**
 * Queue
 *
 * @author shisong
 * @date 2019/4/9
 */
public interface Queue<E> {

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 查询队头的元素
     * @return
     */
    E getFront();

    /**
     * 查询队列的长度
     * @return
     */
    int getSize();

    /**
     * 查询队列是否为空
     * @return
     */
    boolean isEmpty();

}
