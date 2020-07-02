package com.ss.gupao.serializer.second;

/**
 * XmlSerializer
 *
 * @author shisong
 * @date 2020/6/18
 */
public class XmlSerializer<T> implements ISerializer<T>{

    //XStream stream=new XStream(new DomDriver());

    @Override
    public byte[] serialize(T obj) {

        return new byte[0];
    }

    @Override
    public T deSerialize(byte[] bytes) {
        return null;
    }
}
