package com.ss.design.pattern.creational.factorymethod;

public class HondaCar extends Car {
    @Override
    void produce() {
        System.out.println("生产了本田汽车！");
    }
}
