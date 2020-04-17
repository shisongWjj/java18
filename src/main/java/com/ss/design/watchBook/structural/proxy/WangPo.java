package com.ss.design.watchBook.structural.proxy;

/**
 * WangPo
 *
 * @author shisong
 * @date 2020/4/15
 */
public class WangPo implements KindWoman{

    private KindWoman kindWoman;

    public WangPo() {
        this(new PanJinLian());
    }

    public WangPo(KindWoman kindWoman) {
        this.kindWoman = kindWoman;
    }

    @Override
    public void happyWithMan() {
        this.kindWoman.happyWithMan();
    }

    @Override
    public void eyesWithMan() {
        this.kindWoman.eyesWithMan();
    }
}
