package com.ss.jvm;

import org.apache.ibatis.javassist.expr.Instanceof;

import java.io.InputStream;

public class TestBean {

    /*public TestBean(){};*/

    public static void main(String[] args) {

        //一个简单的类加载器，逆向双亲委派机制
        //可以加载与自己在同一个路径下的class文件
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String filename = name.substring(name.lastIndexOf(".")+1);
                    InputStream is = getClass().getResourceAsStream(filename);
                    if(is == null){
                        //说明文件不存在
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name,bytes,0,bytes.length);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return super.loadClass(name);
            }
        };

        try {
            Object o = myClassLoader.loadClass("com.ss.jvm.TestBean").newInstance();
            System.out.println(o);
            System.out.println(o instanceof com.ss.jvm.TestBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
