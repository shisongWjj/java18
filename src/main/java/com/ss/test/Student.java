package com.ss.test;

/**
 * Student
 *
 * @author shisong
 * @date 2020/1/8
 */
public class Student extends Person{

    private String no;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                '}';
    }
}
