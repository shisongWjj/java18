package com.ss.design.pattern.creational.builder;

public abstract class CourseBuilder {

   public abstract void buildCourseName(String courseName);
   public abstract void buildCorusePPT(String corusePPT);
   public abstract void buildCourseVideo(String courseVideo);
   public abstract void buildCourseArticle(String courseArticle);
   public abstract void buildCourseQA(String courseQA);

   public abstract Course makeCourse();

}
