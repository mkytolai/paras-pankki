package com.paras.bankki;

import com.paras.bankki.account.Account;
import com.paras.bankki.account.Balance;
import com.paras.bankki.customer.Customer;

import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<Customer, Account> accounts = new HashMap<>();
    void createAccount(Customer customer, Account account) {
        accounts.put(customer, account);
    }

    Balance getBalance(Customer customer) {
        Account account = accounts.get(customer);
        return account.getBalance();
    }
}
