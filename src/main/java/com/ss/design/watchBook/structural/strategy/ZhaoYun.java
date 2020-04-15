package com.ss.design.watchBook.structural.strategy;

/**
 * ZhaoYun
 *
 * @author shisong
 * @date 2020/4/15
 */
public class ZhaoYun {

    public static void main(String[] args) {
        //锦囊1
        Content content = new Content(new BackDoorStrategyService());
        content.operate();
        //锦囊2
        content = new Content(new GivenGreenLightStrategyService());
        content.operate();
        //锦囊3
        content = new Content(new BlockEnemyStrategyService());
        content.operate();
    }

}
