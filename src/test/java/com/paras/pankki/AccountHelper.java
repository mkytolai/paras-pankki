package com.paras.pankki;

import com.paras.pankki.account.Balance;
import com.paras.pankki.account.Helper;
import com.paras.pankki.account.InMemory;

class AccountHelper {
    private Helper helper;

    AccountHelper() {
        helper = new InMemory();
    }

    void deposit(String customer, Integer balance, String currency) {
        helper.deposit(customer, balance, currency);
    }

    Balance getBalance() {
        return helper.getBalance();
    }
}
