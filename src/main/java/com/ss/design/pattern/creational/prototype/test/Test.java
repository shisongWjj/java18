package com.ss.design.pattern.creational.prototype.test;

/**
 * CamelUtils
 *
 * @author shisong
 * @date 2019/1/9
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        CacheKeyTest cacheKeyTest = new CacheKeyTest();
        CacheKeyTest clone = cacheKeyTest.clone();
        /**
         * 17:0com.ss.design.pattern.creational.prototype.test.CacheKeyTest@11
         17:0com.ss.design.pattern.creational.prototype.test.CacheKeyTest@11
         发现是一样的，应该是不一样，然后查询对象里，发现他重写了hashCode方法，注释掉，就发现不一样了
         17:0com.ss.design.pattern.creational.prototype.test.CacheKeyTest@7d6f77cc
         17:0com.ss.design.pattern.creational.prototype.test.CacheKeyTest@5aaa6d82

         无论有没有重写hashcode方法，发现updateList 都不是同一个对象
         */
        System.out.println(cacheKeyTest);
        System.out.println(clone);


    }
}
