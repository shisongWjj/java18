package com.ss.design.pattern.creational.factorymethod;

public class HondaCarFactory extends CarFactory {
    @Override
    public Car getCar() {
        return new HondaCar();
    }
}
