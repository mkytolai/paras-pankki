package com.paras.pankki.account;

public class Balance {
    private Integer balance;
    private PankkiCurrency currency;

    public Balance(Integer balance, PankkiCurrency currency) {
        this.balance = balance;
        this.currency = currency;
    }

    public Integer getBalance() {
        return balance;
    }

    public PankkiCurrency getCurrency() {
        return currency;
    }
}
