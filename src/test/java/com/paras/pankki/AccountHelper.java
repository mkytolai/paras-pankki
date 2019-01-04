package com.paras.pankki;

import com.paras.pankki.account.*;

class AccountHelper {
    private Adapter helper;
    private String currentCustomer;

    AccountHelper() {
        if (System.getProperty("E2E") != null) {
            helper = new RestClientAdapter();
        } else {
            helper = new InMemoryAdapter();
        }
    }

    void deposit(Integer amount, String currency) {
        helper.deposit(currentCustomer, amount, currency);
    }

    void setCurrentCustomer(String currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    Balance getBalance() {
        return helper.getBalance(currentCustomer);
    }

    void withdraw(Integer amount, String currency){
        Balance balance = new Balance(amount, new Currency(currency));
        helper.withdraw(currentCustomer, balance);
    }
}
