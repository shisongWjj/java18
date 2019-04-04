package com.ss.design.pattern.creational.abstractfactory;

public class Test {

    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCoureFactory();
        Article article = courseFactory.getArticle();
        Video video = courseFactory.getVideo();
        article.produce();
        video.produce();
    }
}
