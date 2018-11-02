package com.ss.design.principle.dependeceinversion;

public class BuickCar implements ICar{
    @Override
    public void driveCar() {
        System.out.println("小明在开别克车");
    }
}
