package com.ss.design.pattern.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        //LazySingleton lazySingleton = LazySingleton.getInstatnce();
        System.out.println("mian" + ThreadLocalInstance.getInstance());
        System.out.println("mian" + ThreadLocalInstance.getInstance());
        System.out.println("mian" + ThreadLocalInstance.getInstance());
        System.out.println("mian" + ThreadLocalInstance.getInstance());
        System.out.println("mian" + ThreadLocalInstance.getInstance());
        System.out.println("mian" + ThreadLocalInstance.getInstance());
        System.out.println("mian" + ThreadLocalInstance.getInstance());
        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        t1.start();
        t2.start();
        System.out.println("program end");

        //使用（反）序列化来创建对象
        // 这里以饿汉式作为示例
        /*HungrySingleton instance = HungrySingleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("instance")));
        oos.writeObject(instance);

        ObjectInputStream ios = new ObjectInputStream(new FileInputStream(new File("instance")));
        HungrySingleton newInstance = (HungrySingleton) ios.readObject();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(newInstance == instance);*/

        //使用反射来创建对象
        /*Class objectClass = HungrySingleton.class;
        Constructor c = objectClass.getDeclaredConstructor();
        c.setAccessible(true);

        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton newInstance = (HungrySingleton) c.newInstance();*/

        /*Class objectClass = StaticInnerClassSingleton.class;
        Constructor c = objectClass.getDeclaredConstructor();
        c.setAccessible(true);

        StaticInnerClassSingleton newInstance = (StaticInnerClassSingleton) c.newInstance();
        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(newInstance == instance);*/

        /*EnumInstance instance = EnumInstance.getInstance();
        instance.setData(new Object());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("instance")));
        oos.writeObject(instance);

        ObjectInputStream ios = new ObjectInputStream(new FileInputStream(new File("instance")));
        EnumInstance newInstance = (EnumInstance) ios.readObject();

        System.out.println(instance.getData());
        System.out.println(newInstance.getData());
        System.out.println(newInstance.getData() == instance.getData());*/

        /*EnumInstance instance1 = Enum.valueOf(EnumInstance.class, "INSTANCE");
        System.out.println(instance1);

        Class objectClass = EnumInstance.class;
        Constructor c = objectClass.getDeclaredConstructor(String.class,int.class);
        c.setAccessible(true);

        EnumInstance newInstance = (EnumInstance) c.newInstance("aaaa",123);
        EnumInstance instance = EnumInstance.getInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(newInstance == instance);*/


    }

}
