package com.ss.dataStructures.linkedList;

/**
 * Node
 *
 * @author shisong
 * @date 2020/6/1
 */
public class Node<E> {

    /**
     * 当前节点的元素
     */
    public E e;

    /**
     * 指向的下一个节点
     */
    public Node next;

    public Node(E e, Node next) {
        this.e = e;
        this.next = next;
    }

    public Node(E e) {
        this(e, null);
    }

   /* public static void main(String[] args) {
        Node tail = new Node(6);
        Node temp = new Node(5,tail);
        Node head = new Node(4,temp);
        System.out.println(tail);
        System.out.println(temp);
        System.out.println(head);
        //tail temp
        //node.prev = pred = pred.prev;
        head.next = temp = temp.next;

        System.out.println(tail);
        System.out.println(temp);
        System.out.println(head);
        System.out.println(head.next.next);
    }*/

    public Node() {
        this(null, null);
    }

   /* @Override
    public String toString() {
        return e.toString();
    }*/

}
