package com.ss.dataStructures.queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    /**
     * 队列头部的索引
     */
    private int front;

    /**
     * 队列尾部的下一个索引
     */
    private int tail;

    /**
     * 队列中有多少个元素
     */
    private int size;

    /**
     * 有参构造
     *
     * @param capacity
     */
    public LoopQueue(int capacity) {
        //由于当队列满的时候 会有意识的浪费一个空间，所以这里我们创建的时候 应该要比它传入的大1
        data = (E[]) new Object[capacity + 1];
        size = 0;
        front = 0;
        tail = 0;
    }

    /**
     * 无参构造
     */
    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        //int lastIndex = (tail + 1) % data.length; 不能这样写，因为扩容后  data.length的值已经发生改变了
        if ((tail + 1) % data.length == front) {
            //说明队列已满 需要扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 扩容
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (front == tail) {
            //说明队列为空
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return result;
    }

    @Override
    public E getFront() {
        if (front == tail) {
            //说明队列为空
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 返回队列的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue  size:%d , capacity:%d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i % 3 == 2) {
                queue.dequeue();
            }
            System.out.println(queue.toString());
        }
    }
}
