package com.ss.design.pattern.creational.factorymethod;

public abstract class CarFactory {

    public abstract Car getCar();

    /*public Car getCar(String type){
        if(type.equalsIgnoreCase("本田")){
            return new HondaCar();
        }else if(type.equalsIgnoreCase("福特")){
            return new FordCar();
        }
        return null;
    }

    public Car getCar(Class c){
        Car car = null;

        try {
            car = (Car) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return car;
    }*/
}
