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
       /* for(int i = 0;i<10;i++){
            Manager manager = (Manager) EmployeeFactory.getEmployee(departments[(int) (Math.random() * departments.length)]);
            manager.report();
        }*/

       /*Integer a = new Integer(100);
       Integer b = 100;
       Integer c = Integer.valueOf(100);

        *//**
         * false
         false
         true
         *//*
       System.out.println(a==b);
       System.out.println(a==c);
       System.out.println(c==b);*/

        /*Integer a = new Integer(100);
        Integer b = 100;
        Integer c = Integer.valueOf(100);
        int d = 100;
        *//**
         * true
         true
         *//*
        System.out.println(d==c);
        System.out.println(d==a);*/

        Integer a = new Integer(1000);
        Integer b = 1000;
        Integer c = Integer.valueOf(1000);
        int d = 1000;
        /**
         * true
         true
         true
         */
        System.out.println(d==c);
        System.out.println(d==a);
        System.out.println(d==b);


    }

}
