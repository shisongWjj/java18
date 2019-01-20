package com.ss.design.pattern.behavioral.iterator;

/**
 * CourseIterator
 *
 * @author shisong
 * @date 2019/1/21
 */
public interface CourseIterator<T> {

    T nextCourse();

    Boolean lastCourse();

}
