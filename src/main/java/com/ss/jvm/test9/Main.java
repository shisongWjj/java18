package com.ss.jvm.test9;

/**
 * Main
 *
 * @author shisong
 * @date 2019/3/26
 */
public class Main {

    public static void main(String[] args) {
        int hour = 24;
        long mi = hour * 60 * 60 * 1000;
        System.out.println(mi);
        long mic = hour * 60 * 60 * 1000 * 1000;
        System.out.println(mic);
        System.out.println(mic / mi);
    }

}
