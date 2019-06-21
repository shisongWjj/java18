package com.ss.jvm.testblog;

import java.io.*;
import java.lang.reflect.Constructor;

public class Student implements Cloneable, Serializable {

    private Integer id;

    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws Exception {
        //1.new 来创建实例
        System.out.println("new关键字创建对象：");
        Student student1 = new Student(123);
        System.out.println(student1);
        System.out.println("====================");

        //2.利用class 反射
        System.out.println("使用Class类的newInstance方法创建对象：");
        //Class.forName("com.ss.jvm.Student").newInstance();
        Student student2 = Student.class.newInstance();//对应类必须具有无参构造方法，且只有这一种创建方式
        System.out.println(student2);
        System.out.println("====================");

        //3.利用Constructor
        System.out.println("使用Constructor类的newInstance方法创建对象：");
        Constructor<Student> constructor = Student.class.getConstructor(Integer.class);
        Student student3 = constructor.newInstance(456);
        System.out.println(student3);
        System.out.println("====================");

        //4.使用clone方式
        System.out.println("使用Clone方法创建对象：");
        Student student4 = (Student) student3.clone();
        System.out.println(student4);
        System.out.println("====================");

        //5.使用反序列化方式
        System.out.println("使用(反)序列化机制创建对象：");
        //写对象
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("student.bin"));
        outputStream.writeObject(student4);
        outputStream.close();

        //读取对象
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("student.bin"));
        Student student = (Student) inputStream.readObject();
        inputStream.close();
        System.out.println(student);

    }
}
