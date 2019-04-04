package com.ss.design.principle.demeter;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader {
    public Integer courseCount() {
        List<Course> courseList = new ArrayList<>();
        for (int i = 0;i<20;i++){
            Course course = new Course();
            courseList.add(course);
        }
        return courseList.size();
    }
}
