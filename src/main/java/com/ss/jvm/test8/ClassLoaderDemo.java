package com.ss.jvm.test8;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassLoaderDemo
 *
 * @author shisong
 * @date 2019/3/12
 */
public class ClassLoaderDemo {

    public static void main(String[] args) throws Exception {
        ClassLoader mycl = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream ins = getResourceAsStream(fileName);
                if (ins == null) {
                    return super.loadClass(name);
                }
                try {
                    byte[] buff = new byte[ins.available()];
                    ins.read(buff);
                    return defineClass(name, buff, 0, buff.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException();
                }
            }
        };

        Object o = mycl.loadClass("com.ss.jvm.test8.ClassLoaderDemo").newInstance();
        System.out.println(o.getClass());
    }

}
