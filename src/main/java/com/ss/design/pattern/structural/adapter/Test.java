package com.ss.design.pattern.structural.adapter;

/**
 * CamelUtils
 * 场景：由220V的交流电变为5V的直流电
 *
 * @author shisong
 * @date 2019/1/14
 */
public class Test {

    public static void main(String[] args) {
        DC5V dc5 = new PowerAdapter();
        dc5.outputDC5V();
    }

}
