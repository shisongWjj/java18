package com.ss.design.pattern.creational.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);

        Course course = coach.makeCourse("java课程", "java课程PPT", "java课程视频", "java课程手记", "java课程问答");
        System.out.println(course);
    }

   /* public static void main(String[] args) {
        *//*List<Integer> lsits = Arrays.asList(1, 2, 3, 4);
        lsits.add(5);
        System.out.println(lsits);*//*
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        System.out.println(lists);
    }*/
}
