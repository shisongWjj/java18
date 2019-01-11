package com.ss.design.pattern.creational.prototype;

import com.ss.design.pattern.creational.singleton.HungrySingleton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Test
 *
 * @author shisong
 * @date 2019/1/9
 */
public class Test {

    /*public static void main(String[] args) {
        *//**
         * 打印结果：
         * 向姓名0同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名1同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名2同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名3同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名4同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名5同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名6同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名7同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名8同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名9同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         存储originMail记录,originMail:恭喜您，中奖了
         我们发现，我们应该要保存下来的原始模板发生变化了，其实按照我们想要的，应该是原始模板不改变，所以我们需要对mail类进行修改
         *//*
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        for(int i = 0;i<10;i++){
            mail.setName("姓名"+i);
            mail.setContent("姓名"+i+"@163.com");
            mail.setContent("恭喜您，中奖了");
            MailUitl.sendMessage(mail);
        }
        MailUitl.saveOriginMailRecord(mail);
    }*/


   /* public static void main(String[] args) throws CloneNotSupportedException {
        *//**
         * 向姓名0同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名1同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名2同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名3同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名4同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名5同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名6同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名7同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名8同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         向姓名9同学,邮件地址:null,邮件内容:恭喜您，中奖了 发送邮件成功
         存储originMail记录,originMail:初始化模板
         *//*
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        for(int i = 0;i<10;i++){
            Mail mailtemp = (Mail) mail.clone();
            mailtemp.setName("姓名"+i);
            mailtemp.setContent("姓名"+i+"@163.com");
            mailtemp.setContent("恭喜您，中奖了");
            MailUitl.sendMessage(mailtemp);
        }
        MailUitl.saveOriginMailRecord(mail);
    }*/
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //克隆破坏单列模式
        /**
         * com.ss.design.pattern.creational.singleton.HungrySingleton@6f75e721
         com.ss.design.pattern.creational.singleton.HungrySingleton@69222c14
         发现不是同一个对象了，那么怎么修改呢，
         第一：就是不让他克隆
         第二：重写克隆方法
         */
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        Method declaredMethod = hungrySingleton.getClass().getDeclaredMethod("clone");
        declaredMethod.setAccessible(true);
        HungrySingleton invoke = (HungrySingleton) declaredMethod.invoke(hungrySingleton);

        System.out.println(hungrySingleton);
        System.out.println(invoke);
    }
}
