package com.ss.gupao.Serializer.first;

import java.io.IOException;
import java.io.Serializable;

/**
 * User
 *
 * @author shisong
 * @date 2020/6/16
 */
public class User implements Serializable{

    private String name;

    private transient int age;

    private transient int sex;

    private void readObject(java.io.ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int i = s.readInt();
        System.out.println(i);
        //在这里 我们可以进行解密
        this.age = i;

        int i1 = s.readInt();
        System.out.println(i1);
        //在这里 我们可以进行解密
        this.sex = i1;
    }
    private void writeObject(java.io.ObjectOutputStream s)
            throws IOException {
        s.defaultWriteObject();
        //在这里 我们可以进行加密
        s.writeInt(this.age);
        s.writeInt(this.sex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
