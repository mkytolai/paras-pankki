package com.paras.pankki.account;

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
    /**
    private Integer sumOfBalance()
    {
        Integer sum = 0;
        for(Integer x : balance)
        {
            sum += x;
        }
        return sum;
    }
     **/

    public Integer getBalance() {
        return this.balance;
    }

    public Currency getCurrency() {
        return currency;
    }
}
