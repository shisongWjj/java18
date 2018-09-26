package com.ss.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 一。缓冲区（buffer）:在java nio 中负责数据的存取，缓冲区就是数组。用于存储不同数据类型的数据
 *
 * 根据数据数据类型不同（Boolean 除外），提供了相应类型的缓存区：
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎是一致的，通过allocate()获取缓冲区
 *
 * 二。缓冲区存取数据的两个核心方法：
 * put()：存入数据到缓冲区中
 * get()：获取缓冲区中的数据
 *
 * 三、缓冲区中的四大核心属性：
 * mark
 * position ：位置，表示缓冲区中正在操作数据的位置
 * limit ：界限，表示缓冲区中可以操作数据的大小。（limit 后数据是不能进行读写的）
 * capacity：容量，表示缓冲区中最大存储数据的容量，一旦声明不能改变
 *
 */
public class TestBuffer {

    @Test
    public void test1(){
        String str = "abcde";
        //1.分配一个指定大小的缓存区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("=============allocate================");
        System.out.println(buffer.mark());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //2.利用put()存入数据到缓冲区中
        buffer.put(str.getBytes());
        System.out.println("=============put================");
        System.out.println(buffer.mark());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.flip();
    }

}
