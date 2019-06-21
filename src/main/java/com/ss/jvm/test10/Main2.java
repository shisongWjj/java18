package com.ss.jvm.test10;

/**
 * Main2
 *
 * @author shisong
 * @date 2019/3/26
 */
public class Main2 {

    public void sayHello(short a) {
        System.out.println("short");
    }

    public void sayHello(Object a) {
        System.out.println("Object");
    }

   /* public void sayHello(int a){
        System.out.println("int");
    }*/

    /*public void sayHello(char a){
        System.out.println("char");
    }*/

    /*public void sayHello(long a){
        System.out.println("long");
    }*/

    /*public void sayHello(Character a){
        System.out.println("Character");
    }*/

    public void sayHello(char... a) {
        System.out.println("数组");
    }

    public static void main(String[] args) {
        //char->int->long->Character->object->char...
        new Main2().sayHello('a');
    }

}
