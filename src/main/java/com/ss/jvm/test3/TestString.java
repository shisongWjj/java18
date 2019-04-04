package com.ss.jvm.test3;

/**
 * TestString
 *
 * @author shisong
 * @date 2019/1/25
 */
public class TestString {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        /**
         * 推断运行时常量池的存在
         * String是引用数据类型，按照java运行时数据区，我们可以知道，它应该是存放在虚拟机栈中的栈帧中的局部变量表中，
         * 每次创建应该都会在堆中开辟一个新的内存空间，所以地址值会不一样，所以s1==s2 应该返回false
         * 然后结果却是true,那就说String s1 = "abc"并非在堆中操作，是在专门的一块区域存储，这个区域就是运行时常量池
         *
         * 在内存中存在一个字符串池（运行时常量池），当应用发起创建字符串的请求时，
         * VM会先检查这个字符串在池中存不存在，如果存在就直接将其返回给应用了，如果不存在才创建这个字符串对象。
         * 这样做是因为字符串是应用中最常用的东西，如果每个字符串都创建一个对象，开销巨大，所以采取此种方式
         */
        System.out.println(s1 == s2);//true

        /**
         * 根据上述的理论，这里应该也是返回true,事实却是返回false，那是应该new的话，都是在堆中开辟一块内存空间，用来存放的。
         * 所以，一个在常量池中，一个在堆中，肯定不相等
         */
        String s3 = new String("abc");
        System.out.println(s1 == s3);//false

        String s4 = String.valueOf("abc");
        System.out.println(s1 == s4);//true?

        String s5 ="a";
        String s6 = "bc";
        String s7 = s5+s6;
        System.out.println(s1==s7);//false

    }

}
