package com.ss.design.principle.dependeceinversion;

public class FordCar implements ICar {
    @Override
    public void driveCar() {
        System.out.println("小明在开福特车");
    }
}
