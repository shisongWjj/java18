package com.ss.design.pattern.creational.prototype;

import java.text.MessageFormat;

/**
 * MailUitl
 *
 * @author shisong
 * @date 2019/1/9
 */
public class MailUitl {

    /**
     * 发送邮件
     * @param mail
     */
    public static void sendMessage(Mail mail){
        String outputContent="向{0}同学,邮件地址:{1},邮件内容:{2} 发送邮件成功";
        System.out.println(MessageFormat.format(outputContent,mail.getName(),mail.getAddress(),mail.getContent()));
    }

    /**
     * 保存原始邮件
     * @param mail
     */
    public static void saveOriginMailRecord(Mail mail){
        System.out.println("存储originMail记录,originMail:"+mail.getContent());
    }

}
