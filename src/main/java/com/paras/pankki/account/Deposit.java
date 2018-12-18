package com.paras.pankki.account;


import java.util.Objects;

public class Deposit {
    private  Account account;
    private  Balance balance;

    public Deposit() {
    }

    Deposit(Balance balance, Account account) {
        this.balance = balance;
        this.account = account;
    }

    public Balance getBalance() {
        return this.balance;
    }

    public Account getAccount() {
        return this.account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return Objects.equals(account, deposit.account) &&
                Objects.equals(balance, deposit.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, balance);
    }
}
