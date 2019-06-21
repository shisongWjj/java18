package com.ss.design.pattern.structural.bridge;

/**
 * CamelUtils
 *
 * @author shisong
 * @date 2019/1/17
 */
public class Test {

    public static void main(String[] args) {
        Bank abcBank = new ABCBank(new DepositAccount());
        Account abcAccount = abcBank.openAccount();
        abcAccount.showAccountType();

        Bank abcBank2 = new ABCBank(new SavingAccount());
        Account abcAccount2 = abcBank2.openAccount();
        abcAccount2.showAccountType();

        Bank icbcBank = new ICBCBank(new SavingAccount());
        Account icbcAccount = icbcBank.openAccount();
        icbcAccount.showAccountType();

    }

}
