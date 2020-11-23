package com.ss.test;

/**
 * Person
 *
 * @author shisong
 * @date 2020/1/8
 */
public class Person {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
