package com.paras.bankki.account;

public class Balance {

    private Integer balance;
    private String currency;

    public Balance(Integer balance, String currency) {
        this.balance = balance;
        this.currency = currency;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }
}
