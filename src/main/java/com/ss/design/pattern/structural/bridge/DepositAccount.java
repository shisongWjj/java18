package com.ss.design.pattern.structural.bridge;

/**
 * DepositAccount 定期账号
 *
 * @author shisong
 * @date 2019/1/17
 */
public class DepositAccount implements Account{
    @Override
    public Account openAccount() {
        System.out.println("打开定期账号");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是定期账号");
    }
}
