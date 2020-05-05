package com.ss.design.watchBook.structural.strategy;

/**
 * Content
 *
 * @author shisong
 * @date 2020/4/15
 */
public class Content {

    private IStrategy strategy;

    public Content(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void operate(){
        strategy.operate();
    }
}
