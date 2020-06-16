package com.ss.gupao.serializer.second;

/**
 * ISerializer
 *
 * @author shisong
 * @date 2020/6/16
 */
public interface ISerializer<T> {

    /**
     * 序列化
     * @param obj 需要序列化的对象
     * @return 二进制数据
     */
    byte[] serialize(T obj);

    /**
     * 反序列化
     * @param bytes 二进制数据
     * @return 反序列化后的对象
     */
    T deSerialize(byte[] bytes);

}
