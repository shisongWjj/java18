package com.ss.design.pattern.behavioral.iterator;

import java.util.List;

/**
 * CourseIteratorImpl
 *
 * @author shisong
 * @date 2019/1/21
 */
public class CourseIteratorImpl implements CourseIterator{

    private List<Course> courseList;

    private int position;

    private Course course;

    public CourseIteratorImpl(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public Course nextCourse() {
        System.out.println("返回课程，位置是："+position);
        course = courseList.get(position);
        position++;
        return course;
    }

    @Override
    public Boolean lastCourse() {
        if(position < courseList.size()){
            return false;
        }
        return true;
    }
}
