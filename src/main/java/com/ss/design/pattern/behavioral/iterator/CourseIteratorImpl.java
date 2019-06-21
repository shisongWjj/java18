package com.ss.design.pattern.behavioral.iterator;

import java.util.List;

/**
 * CourseIteratorImpl
 *
 * @author shisong
 * @date 2019/1/21
 */
public class CourseIteratorImpl<T> implements CourseIterator<T> {

    private List<T> courseList;

    private int position;

    private T course;

    public CourseIteratorImpl(List<T> courseList) {
        this.courseList = courseList;
    }

    @Override
    public T nextCourse() {
        System.out.println("返回课程，位置是：" + position);
        course = courseList.get(position);
        position++;
        return course;
    }

    @Override
    public Boolean lastCourse() {
        if (position < courseList.size()) {
            return false;
        }
        return true;
    }
}
