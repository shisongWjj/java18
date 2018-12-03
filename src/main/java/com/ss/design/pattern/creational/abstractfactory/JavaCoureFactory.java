package com.ss.design.pattern.creational.abstractfactory;

public class JavaCoureFactory implements CourseFactory{
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
