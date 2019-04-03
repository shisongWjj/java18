package com.ss.dataStructures.Array;

/**
 * Array
 *
 * @author shisong
 * @date 2019/4/2
 */
public class Array {

    //数组
    private int[] data;

    //数组中元素的个数
    private int size;

    /**
     * 有参构造，传入容量大小，创建数组大小
     * @param capacity
     */
    public Array(int capacity){
        data = new int[capacity];
        size =0;
    }

    /**
     * 无参构造，默认数组的容量capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 返回数组中元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在第一个位置添加元素
     * @param e
     */
    public void addFirst(int e){
        add(0,e);
    }

    /**
     * 在最后一个位子添加元素
     * @param e
     */
    public void addLast(int e){
        /*if(size == data.length){
            throw new IllegalArgumentException("add failed.Array is full");
        }
        data[size] = e;
        size++;*/
        //可以直接调用add方法
        add(size,e);
    }

    /**
     * 在指定的位置添加一个元素
     * @param index
     * @param e
     */
    public void add(int index,int e){
        if(size == data.length){
            throw new IllegalArgumentException("add failed.Array is full");
        }
        if(index < 0 || index >size){
            throw new IllegalArgumentException("add failed.required index >= 0 || index <= size");
        }
        for(int i = size; i >= index ; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array  size:%d , capacity:%d\n",size,data.length));
        sb.append("[");
        for (int i = 0;i<size;i++){
            sb.append(data[i]);
            if(i == (size-1)){
                sb.append("]");
            }else{
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
