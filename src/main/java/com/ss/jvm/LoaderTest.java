package com.ss.jvm;

public class LoaderTest {

    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(ClassLoader.getSystemClassLoader().getParent());// sun.misc.Launcher$ExtClassLoader@71dac704
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());//null
        System.out.println(sun.misc.Launcher.getLauncher().getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
    }

}
