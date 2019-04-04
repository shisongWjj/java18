package com.ss.design.principle.dependeceinversion;

public class XiaoMing {

    /*public void driveFordCar(){
        System.out.println("小明在开福特车");
    }

    public void driveHondaCar(){
        System.out.println("小明在开本田车");
    }

    public void driveBuickCar(){
        System.out.println("小明在开别克车");
    }*/

    private ICar iCar;

   /* public XiaoMing(ICar iCar) {
        this.iCar = iCar;
    }*/

    public void setiCar(ICar iCar) {
        this.iCar = iCar;
    }

    public void driveCar(){
        iCar.driveCar();
    }

}
