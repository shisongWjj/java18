package com.ss.spring;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.util.ClassUtils;

/**
 * Test
 *
 * @author shisong
 * @date 2019/7/1
 */
public class Test {

    public static void main(String[] args) {
        DefaultResourceLoader dr = new DefaultResourceLoader();

       /* ClassLoader defaultClassLoader = ClassUtils.getDefaultClassLoader();
        System.out.println(defaultClassLoader);*/
    }

}
