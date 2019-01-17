package com.ss.design.pattern.structural.bridge;

/**
 * Bank
 *
 * @author shisong
 * @date 2019/1/17
 */
public abstract class Bank {

    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    abstract Account openAccount();
}
