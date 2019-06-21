package com.ss.design.pattern.structural.proxy.staticproxy;

import com.ss.design.pattern.structural.proxy.Order;

/**
 * CamelUtils
 *
 * @author shisong
 * @date 2019/1/17
 */
public class Test {

    /*public static void main(String[] args) {
        int a,b;
        a=4;
        b=5;
        method(a,b);
        System.out.println("a=" + a + ", b="+b);
    }

    private static void method(Integer a, Integer b) {
       *//* try {
     *//**//* Class<?> clazz = a.getClass();
            Field fields = clazz.getDeclaredField("value");
            fields.setAccessible(true);
            fields.set(a, 400);
            fields.set(b, 500);*//**//*
            Class<?> clazz = a.getClass();
            Field field = clazz.getDeclaredField("value");
            field.setAccessible(true);
            field.set(a, 12312);

        } catch (Exception e) {
            e.printStackTrace();
        }*//*
        a *= 100;
        b *= 100;
        System.out.println("a=" + a + ", b="+b);
        System.exit(0);
    }*/

    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }

}
