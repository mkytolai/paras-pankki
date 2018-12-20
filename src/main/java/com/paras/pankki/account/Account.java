package com.paras.pankki.account;

import java.util.Objects;

public class Account {
    private Balance balance;

    public Account() {
    }

    public Balance getBalance() {
        return balance;
    }

    public void deposit(Balance balance) {
        this.balance = balance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }
}
