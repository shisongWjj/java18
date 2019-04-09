package com.ss.dataStructures.array;

/**
 * Array
 *
 * @author shisong
 * @date 2019/4/2
 */
public class Array<E>{
    //数组
    private E[] data;

    //数组中元素的个数
    private int size;

    /**
     * 有参构造，传入容量大小，创建数组大小
     * @param capacity
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
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
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在最后一个位子添加元素
     * @param e
     */
    public void addLast(E e){
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
    public void add(int index,E e){
        if(index < 0 || index >size){
            throw new IllegalArgumentException("add failed.required index >= 0 || index <= size");
        }
        if(size == data.length){
            resize(data.length*2);
        }
        for(int i = size; i >= index ; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 根据下标位置查询元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index>=size || index <0){
            throw new IllegalArgumentException("get fail.index is illegal");
        }
        return data[index];
    }

    /**
     * 查询最后一个元素
     * @return
     */
    public E getLast(){
        return get(size-1);
    }

    /**
     * 查询第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 根据下标位置修改指定元素的值
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index>=size || index <0){
            throw new IllegalArgumentException("set fail.index is illegal");
        }
        data[index] = e;
    }


    /**
     * 重写toString方法
     * @return
     */
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

    /**
     * 查询是否包含某个元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查询某个元素的下标，如果不存在 则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }


    /**
     * 从数组中删除 index的元素，并返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("remove fail.index is illegal");
        }
        E result = data[index];
        for (int i = index+1; i <size ; i++){
            data[i-1] = data[i];
        }
        size--;
        if(data.length/4 == size && data.length/2 != 0){
            resize(data.length/2);
        }
        return result;
    }

    /**
     * 从数组中删除 第一个的元素，并返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除 最后一个的元素，并返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 删除某个元素
     * @param e
     * @return
     */
    public E removeElement(E e){
        int index = find(e);
        return remove(index);
    }

    /**
     * 重置数组的大小
     * @param capacity
     */
    public void resize(int capacity){
        E[] newData = (E[])new Object[capacity];
        for(int i = 0; i< size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
