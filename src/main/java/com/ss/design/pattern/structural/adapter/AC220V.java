package com.ss.design.pattern.structural.adapter;

/**
 * AC220V 被适配者
 *
 * @author shisong
 * @date 2019/1/14
 */
public class AC220V {

    public int outputAC220V() {
        int output = 220;
        System.out.println("输出交流电" + output + "V");
        return output;
    }

}
