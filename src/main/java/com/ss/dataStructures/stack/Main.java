package com.ss.dataStructures.stack;

import java.util.Random;

public class Main {

    /**
     * 测试普通队列和循环队列
     *
     * @param stack
     * @param opCount
     * @return
     */
    private static double testQueue(Stack<Integer> stack, Integer opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        Integer opCount = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double arrayStackTime = testQueue(arrayStack, opCount);
        System.out.println("arrayStackTime : " + arrayStackTime);

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double linkedListStackTime = testQueue(linkedListStack, opCount);
        System.out.println("linkedListStackTime : " + linkedListStackTime);
        //ArrayStack
        System.out.println(arrayStack.getClass().getSimpleName());
    }

}
