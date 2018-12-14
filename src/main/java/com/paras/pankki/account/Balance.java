package com.paras.pankki.account;

import java.util.ArrayList;

public class Balance {
    private ArrayList<Integer> balance;
    private PankkiCurrency currency;

    public Balance(Integer balance, PankkiCurrency currency) {
        this.balance = new ArrayList<>();
        this.balance.add(balance);
        this.currency = currency;
    }
    private Integer sumOfBalance()
    {
        Integer sum = 0;
        for(Integer x : balance)
        {
            sum += x;
        }
        return sum;
    }

    public Integer getBalance() {
        return this.sumOfBalance();
    }

    public PankkiCurrency getCurrency() {
        return currency;
    }
}
