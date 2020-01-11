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
        /*String s = "c";
        transf(s);
        System.out.println(s);*/
        Student student = new Student();
        student.setNo("2123213");
        student.setUserName("3233333");
        print(student);
    }

    public static void print(Person p){
        System.out.println(p);
    }

    public static void transf(String s){
        s = "a";
    }
}
