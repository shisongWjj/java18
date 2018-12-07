package com.ss.design.pattern.creational.singleton;

import java.io.*;

public class Test {

    public static void main(String[] args) throws Exception{
        //LazySingleton lazySingleton = LazySingleton.getInstatnce();
       /* Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        t1.start();
        t2.start();
        System.out.println("program end");*/

        //使用（反）序列化来创建对象
        // 这里以饿汉式作为示例
        HungrySingleton instance = HungrySingleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("instance")));
        oos.writeObject(instance);

        ObjectInputStream ios = new ObjectInputStream(new FileInputStream(new File("instance")));
        HungrySingleton newInstance = (HungrySingleton) ios.readObject();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(newInstance == instance);
    }

}
