package com.ss.design.principle.dependeceinversion;

public class HondaCar implements ICar {
    @Override
    public void driveCar() {
        System.out.println("小明在开本田车");
    }
}
