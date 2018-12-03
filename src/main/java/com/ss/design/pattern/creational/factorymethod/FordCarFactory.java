package com.ss.design.pattern.creational.factorymethod;

public class FordCarFactory extends CarFactory {
    @Override
    public Car getCar() {
        return new FordCar();
    }
}
