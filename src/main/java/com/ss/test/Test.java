package com.ss.test;

/**
 * Test
 *
 * @author shisong
 * @date 2019/12/28
 */
public class Test {

    public static void main(String[] args) {
        /*try {
            System.out.println("1111");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("2222");
        }*/
        String s = "c";
        transf(s);
        System.out.println(s);
    }

    public static void transf(String s){
        s = "a";
    }
}
