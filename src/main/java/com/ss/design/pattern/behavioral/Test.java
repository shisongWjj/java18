package com.ss.design.pattern.behavioral;

/**
 * Test
 *
 * @author shisong
 * @date 2019/1/20
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("测试后端代码开始");
        ACourse designPatternCourse = new DesignPatternCourse();
        designPatternCourse.makeCourse();
        System.out.println("测试后端代码结束");


        System.out.println("测试前端代码开始");
        ACourse feCourse = new FECourse(false);
        feCourse.makeCourse();
        System.out.println("测试前端代码结束");
    }

}
