package com.ss.design.pattern.structural.adapter;

import com.ss.design.pattern.structural.adapter.AC220V;
import com.ss.design.pattern.structural.adapter.DC5V;

/**
 * PowerAdapter 电压适配器
 *
 * @author shisong
 * @date 2019/1/14
 */
public class PowerAdapter implements DC5V{

    AC220V ac220 = new AC220V();

    @Override
    public int outputDC5V() {
        int adapterInput = ac220.outputAC220V();
        //变压器
        int adapterOutput = adapterInput / 44;
        System.out.println("使用PowerAdapter输入AC："+adapterInput + "V，输出DC:"+adapterOutput+"V");
        return adapterOutput;
    }
}
