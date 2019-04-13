package com.ss.dataStructures.queue;

import com.ss.dataStructures.linkedList.LinkedList;

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
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E result = head.e;
        Node newHead = head.next;
        head.next = null;
        head = newHead;
        if(head == null){
            tail = null;
        }
        size--;
        return result;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        //这里判断的时候  只要cur 不为空 而不是cur.e 不为空
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0 ; i< 10 ;i++){
            queue.enqueue(i);
            if(i % 3 == 2){
                queue.dequeue();
            }
            System.out.println(queue.toString());
        }
    }
}
