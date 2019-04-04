package com.ss.design.pattern.creational.factorymethod;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 场景。。 生产汽车。。
 * 一般：创建一个抽象类或者接口Car，然后具体什么汽车，直接继承或实现Car
 * 调用的时候，利用多态，直接创建子类或者实现类。
 * 然而这种方式的缺点，应用层依赖了 无需关系的类
 *
 * 改进1：创建一个工厂类，根据传入的类型来创建实例。
 * 缺点，每次新增一个类型，都要更工厂类的方法。
 *
 * 改进2: 利用反射机制创建实例
 */
public class Test {

    public static void main(String[] args) {
        //V1
        /*Car car = new FordCar();
        car.produce();

        Car car1 = new HondaCar();
        car1.produce();*/

        //v2
        /*CarFactory carFactory = new CarFactory();
        Car car = carFactory.getCar("福特");
        car.produce();*/

        //v3
        CarFactory carFactory = new FordCarFactory();
        Car car = carFactory.getCar();
        car.produce();

        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scutcs","root","root");

        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

}
