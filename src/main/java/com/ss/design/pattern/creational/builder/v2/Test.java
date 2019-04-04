package com.ss.design.pattern.creational.builder.v2;

public class Test {

    public static void main(String[] args) {
        Course course = new Course.CourseBuilder().buildCourseName("java课程").buildCoursePPT("java课程PPT").build();
        System.out.println(course);
    }
}
