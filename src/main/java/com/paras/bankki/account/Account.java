package com.paras.bankki.account;

public class Account {
    private Balance balance;

    public Balance getBalance() {
        return balance;
    }

    public void deposit(Balance balance) {
        this.balance = balance;
    }
}
