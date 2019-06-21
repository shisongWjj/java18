package com.ss.dataStructures.queue;

import java.util.Random;

/**
 * Main
 *
 * @author shisong
 * @date 2019/4/10
 */
public class Main {


    /**
     * 测试普通队列和循环队列
     *
     * @param q
     * @param opCount
     * @return
     */
    private static double testQueue(Queue<Integer> q, Integer opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        Integer opCount = 100000;
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopTime = testQueue(loopQueue, opCount);
        System.out.println("loopTime : " + loopTime);

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayTime = testQueue(arrayQueue, opCount);
        System.out.println("arrayTime : " + arrayTime);

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double linkedListTime = testQueue(linkedListQueue, opCount);
        System.out.println("linkedListTime : " + linkedListTime);
    }

}
