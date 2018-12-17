package com.paras.pankki.account;

import java.util.Objects;

public class Balance {
    private Integer balance;
    private Currency currency;

    public Balance() {
        this.balance = 0;
        this.currency = new Currency("EUR");
    }

    public Balance(Integer balance, Currency currency) {
        this.balance = balance;
        this.currency = currency;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance1 = (Balance) o;
        return Objects.equals(balance, balance1.balance) &&
                Objects.equals(currency, balance1.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, currency);
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balance=" + balance +
                ", currency=" + currency +
                '}';
    }
}
