package com.ss.design.pattern.creational.prototype;

/**
 * Mail
 *  针对mail类的修改，让它实现java.lang.Cloneable类 重写clone方法
 * @author shisong
 * @date 2019/1/9
 */
public class Mail implements Cloneable{

    private String name;
    private String content;
    private String address;

    public Mail() {
    }

    public Mail(String name, String content, String address) {
        this.name = name;
        this.content = content;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
