package com.ss.design.pattern.structural.bridge;

/**
 * SavingAccount
 *
 * @author shisong
 * @date 2019/1/17
 */
public class SavingAccount implements Account{
    @Override
    public Account openAccount() {
        System.out.println("打开活期账号");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是活期账号");
    }
}
