package com.ss.design.principle.openclose;

/**
 * 开闭原则
 * 一门课程有三个属性，id，name,price
 * 现在由于活动，需要一个打折价格
 * 按照传统的想法，直接在原接口里新增一个打折价的接口， 但是如果有多个实现类实现了这个接口的话，就要修改很多个实现类，可能这些实现类本身不需要这个方法
 * 第二种，直接将原价接口改为打折价接口，但是如果这样的话，万一接口还需返回原价，那么。。。
 * 再说，以上两种方法都违背了开闭原则
 * <p>
 * so..  正确方式，再写一个类，继承javacourse
 */
public class Test {

    public static void main(String[] args) {
        ICourse javaCourse = new JavaDiscountCourse(98, "java", 384d);
        //System.out  内含锁
        System.out.println("id:" + javaCourse.getId() + " 名字：" + javaCourse.getName() + " 价格: " + javaCourse.getPrice());
    }
}
