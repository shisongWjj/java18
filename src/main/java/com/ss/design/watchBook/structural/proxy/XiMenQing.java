package com.ss.design.watchBook.structural.proxy;

/**
 * XiMenQing
 *
 * @author shisong
 * @date 2020/4/17
 */
public class XiMenQing {

    public static void main(String[] args) {
        WangPo wangPo = new WangPo();
        wangPo.eyesWithMan();
        wangPo.happyWithMan();

        wangPo = new WangPo(new JiaShi());
        wangPo.eyesWithMan();
        wangPo.happyWithMan();
    }
}
