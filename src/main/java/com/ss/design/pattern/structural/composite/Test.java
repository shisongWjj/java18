package com.ss.design.pattern.structural.composite;

/**
 * CamelUtils
 * 组合模式的缺点：对于类型的处理会很复杂
 *
 * @author shisong
 * @date 2019/1/16
 */
public class Test {

    public static void main(String[] args) {
        CatalogComponent linuxCourse = new Course("Linux课程", 11);
        CatalogComponent windowsCourse = new Course("Windows课程", 11);

        CatalogComponent javaCourseCatalog = new CourseCatalog("java课程目录", 2);

        CatalogComponent mallCourse1 = new Course("电商一期", 55);
        CatalogComponent mallCourse2 = new Course("电商二期", 66);
        CatalogComponent designPattern = new Course("java设计模式", 77);

        javaCourseCatalog.add(mallCourse1);
        javaCourseCatalog.add(mallCourse2);
        javaCourseCatalog.add(designPattern);

        CatalogComponent imoocMainCourseCatalog = new CourseCatalog("慕课网课程主目录", 1);

        imoocMainCourseCatalog.add(linuxCourse);
        imoocMainCourseCatalog.add(windowsCourse);
        imoocMainCourseCatalog.add(javaCourseCatalog);

        imoocMainCourseCatalog.print();

    }
}
