package com.ss.dataStructures.stack;

/**
 * Stack
 *
 * @author shisong
 * @date 2019/4/8
 */
public interface Stack<E> {

    /**
     * 入栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 查询栈顶的元素
     * @return
     */
    E peek();

    /**
     * 查询栈内元素的个数
     * @return
     */
    int getSize();

    /**
     * 查询栈是否为空
     * @return
     */
    boolean isEmpty();

}
