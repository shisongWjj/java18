package com.ss.design.pattern.creational.prototype.clone;

import java.util.Date;

/**
 * CamelUtils
 *
 * @author shisong
 * @date 2019/1/9
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Pig pig1 = new Pig("小猪佩奇", new Date(0L));
        Pig pig2 = (Pig) pig1.clone();
        /**
         * Pig{name='小猪佩奇', birthday=Thu Jan 01 08:00:00 CST 1970}com.ss.design.pattern.creational.prototype.clone.Pig@2ff5659e
         Pig{name='小猪佩奇', birthday=Thu Jan 01 08:00:00 CST 1970}com.ss.design.pattern.creational.prototype.clone.Pig@77afea7d
         我们看到 打印的结果 内容是相同的 但是地址值是不同， 说明是2个对象
         */
        System.out.println(pig1);
        System.out.println(pig2);


        pig1.getBirthday().setTime(6666666666L);
        /**
         * Pig{name='小猪佩奇', birthday=Thu Mar 19 11:51:06 CST 1970}com.ss.design.pattern.creational.prototype.clone.Pig@2ff5659e
         Pig{name='小猪佩奇', birthday=Thu Mar 19 11:51:06 CST 1970}com.ss.design.pattern.creational.prototype.clone.Pig@77afea7d
         我们debug就会发现 其实2个pig对象中的Date地址值是同一个，也就是默认的拷贝方法 只是浅拷贝，只拷贝本身对象，对象内的对象不做拷贝
         pig1.getBirthday()获取到Date对象，对Date重新赋值
         */
        System.out.println(pig1);
        System.out.println(pig2);

        pig1.setBirthday(new Date(66666666666L));
        /**
         * Pig{name='小猪佩奇', birthday=Fri Feb 11 22:31:06 CST 1972}com.ss.design.pattern.creational.prototype.clone.Pig@2ff5659e
         Pig{name='小猪佩奇', birthday=Thu Jan 01 08:00:00 CST 1970}com.ss.design.pattern.creational.prototype.clone.Pig@77afea7d
         我们debug就会发现 其实2个pig对象中的Date地址值是不同
         pig1.setBirthday(new Date(66666666666L));其实是对pig1中的date进行了重新初始化
         */
        System.out.println(pig1);
        System.out.println(pig2);

    }

}
