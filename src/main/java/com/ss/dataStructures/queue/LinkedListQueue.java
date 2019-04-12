package com.ss.dataStructures.queue;

/**
 * LinkedListQueue
 *
 * @author shisong
 * @date 2019/4/12
 */
public class LinkedListQueue<E> implements Queue<E>{

    //内部类
    private class Node{
        //当前节点的元素
        public E e;

        //指向的下一个节点
        public Node next;

        public Node(E e,Node next){
            this.e =e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    //链表头
    private Node head;
    //链表尾
    private Node tail;
    //长度
    private int size;

    /**
     * 无参构造
     */
    public LinkedListQueue(){
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            Node node = new Node(e);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }


}
