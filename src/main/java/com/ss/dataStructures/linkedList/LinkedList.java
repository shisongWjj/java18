package com.ss.dataStructures.linkedList;

/**
 * LinkedList
 *
 * @author shisong
 * @date 2019/4/11
 */
public class LinkedList<E> {
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

    //头节点
    private Node dummyHead;
    //链表的长度
    private int size;

    /**
     * 无参构造
     */
    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 获取链表中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }


    /**
     * 在索引为index的位置 插入元素e
     * @param e
     * @param index 从0开始
     */
    public void add(E e,int index){
        if(index <0 || index >size){
            throw new IllegalArgumentException("add fail.illegal index");
        }
        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i++){
            prev = prev.next;
        }
        /*Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;*/
        prev.next = new Node(e,prev.next);
        size++;
    }

    /**
     * 在链表头添加新的元素e
     * @param e
     */
    public void addFirst(E e){
        /*
        方式一：
        Node node = new Node(e);
        node.next = head;
        head = node;*/

        /*
        方式二：
        Node node = new Node(e,head);
        head = node;*/

        /*head = new Node(e,head);
        size++;*/
        this.add(e,0);
    }

    /**
     * 在链表末尾 添加新的元素e
     * @param e
     */
    public void addLast(E e){
        add(e,size);
    }

    /**
     * 查询索引为index的元素
     * @param index 从0开始
     * @return
     */
    public E get(int index){
        if(index<0 || index >= size){
            throw new IllegalArgumentException("get fail.illegal index");
        }
        Node cur = dummyHead.next;
        for(int i = 0;i < index ; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     * @return
     */
    public E getFirst(){
        return this.get(0);
    }

    /**
     * 获取链表的最后一个元素
     * @return
     */
    public E getLast(){
        return this.get(size-1);
    }

    /**
     * 修改链表中 索引为index的元素的值
     * @param index 从0开始
     * @param e
     */
    public void set(int index,E e){
        if(index<0 || index >=size){
            throw new IllegalArgumentException("update fail.illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0 ; i < index ;i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查询链表中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        /*if(size == 0 ){
            return false;
        }
        Node cur = dummyHead.next;
        for (int i = 0 ; i < size ;i++){
            if(cur.e != null && cur.e.equals(e)){
                return true;
            }
        }
        return false;*/

        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除索引为index的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index<0 || index >=size){
            throw new IllegalArgumentException("remove fail.illegal index.");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index ; i++){

        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        //这里判断的时候  只要cur 不为空 而不是cur.e 不为空
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
