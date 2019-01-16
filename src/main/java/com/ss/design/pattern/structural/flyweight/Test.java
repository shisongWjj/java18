package com.ss.design.pattern.structural.flyweight;

/**
 * Test
 *
 * @author shisong
 * @date 2019/1/16
 */
public class Test {

    public static final String[] departments = {"RD","QA","PM","BD"};

    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            Manager manager = (Manager) EmployeeFactory.getEmployee(departments[(int) (Math.random() * departments.length)]);
            manager.report();
        }

    }

}
