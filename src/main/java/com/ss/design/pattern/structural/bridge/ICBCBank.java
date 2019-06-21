package com.ss.design.pattern.structural.bridge;

/**
 * ICBCBank
 *
 * @author shisong
 * @date 2019/1/17
 */
public class ICBCBank extends Bank {

    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开工商银行账号");
        //将打开账号托管给银行，这里的坑就是，经常会忘记托管
        account.openAccount();
        return account;
    }
}
