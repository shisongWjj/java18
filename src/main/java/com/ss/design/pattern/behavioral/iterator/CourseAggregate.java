package com.ss.design.pattern.behavioral.iterator;

/**
 * CourseAggregate
 *
 * @author shisong
 * @date 2019/1/21
 */
public interface CourseAggregate {

    void addCourse(Course course);

    void removeCourse(Course course);

    CourseIterator getCourseIterator();

}
