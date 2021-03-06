package com.ss.design.pattern.behavioral.templatemethod;

import com.ss.design.pattern.behavioral.templatemethod.ACourse;

/**
 * DesignPatternCourse
 *
 * @author shisong
 * @date 2019/1/20
 */
public class DesignPatternCourse extends ACourse {
    @Override
    void packageCourse() {
        System.out.println("提供课程Java源代码");
    }
}
