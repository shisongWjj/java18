package com.ss.gupao.serializer.second;


import java.io.*;

/**
 * JavaSerializer
 *
 * @author shisong
 * @date 2020/6/16
 */
public class JavaSerializer<T> implements ISerializer<T>{

    @Override
    public byte[] serialize(T obj) {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            return bos.toByteArray();
        }catch (Exception e){
            System.out.println("对象转二进制失败");
        }finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public T deSerialize(byte[] bytes) {
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bis);
            return (T)ois.readObject();
        }catch (Exception e){
            System.out.println("二进制转对象失败");
        }finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
