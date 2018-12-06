package com.paras.bankki;

import com.paras.bankki.account.Account;
import com.paras.bankki.account.Balance;

import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<String, Account> accounts = new HashMap<>();
    void createAccount(String customer, Account account) {
        accounts.put(customer, account);
    }

    Balance getBalance(String customer) {
        Account account = accounts.get(customer);
        return account.getBalance();
    }
}
