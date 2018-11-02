package com.ss.design.principle.dependeceinversion;

/**
 * 倒置依赖原则
 * 情景：小明家很有钱，有本田车和福特车，每次外出都开不同的车
 *  比如小明家又买了一辆车别克，那么
 *  V1版本，则需要在小明这个类中，再定义一个方法 ，这样每次都要对原来的类进行修改，违背了开闭原则
 *  V2版本，小明方法中 只提供一个开车的方法，具体开什么车由调用方传入。
 */
public class Test {

    //v1版本
    /*public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        xiaoMing.driveFordCar();
        xiaoMing.driveHondaCar();
    }*/

    //V2版本
    /*public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        xiaoMing.driveCar(new FordCar());
        xiaoMing.driveCar(new HondaCar());
        xiaoMing.driveCar(new BuickCar());
    }*/

    //v3版本
    //相较于V2，开什么是由创建对象时，就定义好的
    /*public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing(new FordCar());
        xiaoMing.driveCar();
    }*/

    //v4版本
    //相较于V3，具体开什么车，是可变的。对象只需要创建一次
    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        xiaoMing.setiCar(new FordCar());
        xiaoMing.driveCar();
        xiaoMing.setiCar(new HondaCar());
        xiaoMing.driveCar();
        xiaoMing.setiCar(new BuickCar());
        xiaoMing.driveCar();

    }

}
