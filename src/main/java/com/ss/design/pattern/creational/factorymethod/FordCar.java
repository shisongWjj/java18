package com.ss.design.pattern.creational.factorymethod;

public class FordCar extends Car {
    @Override
    void produce() {
        System.out.println("生成了福特汽车！");
    }
}
