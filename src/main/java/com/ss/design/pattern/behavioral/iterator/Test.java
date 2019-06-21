package com.ss.design.pattern.behavioral.iterator;

/**
 * CamelUtils
 *
 * @author shisong
 * @date 2019/1/21
 */
public class Test {

    public static void main(String[] args) {
        Course course1 = new Course("java电商一期");
        Course course2 = new Course("java电商二期");
        Course course3 = new Course("java设计模式精讲");
        Course course4 = new Course("Python课程");
        Course course5 = new Course("算法课程");
        Course course6 = new Course("前端课程");

        CourseAggregate courseAggregate = new CourseAggregateImpl();

        courseAggregate.addCourse(course1);
        courseAggregate.addCourse(course2);
        courseAggregate.addCourse(course3);
        courseAggregate.addCourse(course4);
        courseAggregate.addCourse(course5);
        courseAggregate.addCourse(course6);

        System.out.println("----------课程列表----------");
        printCourses(courseAggregate);

        courseAggregate.removeCourse(course5);
        courseAggregate.removeCourse(course6);

        System.out.println("----------删除列表----------");
        printCourses(courseAggregate);
    }

    private static void printCourses(CourseAggregate courseAggregate) {
        CourseIterator courseIterator = courseAggregate.getCourseIterator();
        while (!courseIterator.lastCourse()) {
            Course course = (Course) courseIterator.nextCourse();
            System.out.println(course.getName());
        }

    }

}
