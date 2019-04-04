package com.ss.design.pattern.structural.bridge;

/**
 * ABCBank
 *
 * @author shisong
 * @date 2019/1/17
 */
public class ABCBank extends Bank{

    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国人民银行账号");
        //将打开账号托管给银行，这里的坑就是，经常会忘记托管
        account.openAccount();
        return account;
    }
}
