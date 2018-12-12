package com.paras.bankki;

import com.paras.bankki.account.Account;
import com.paras.bankki.account.Balance;
import com.paras.bankki.customer.Customer;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Customer, Account> accounts = new HashMap<>();
    public void createAccount(Account account) {
        accounts.put(account.getCustomer(), account);
    }

    public Balance getBalance(Customer customer) {
        Account account = accounts.get(customer);
        return account.getBalance();
    }
}
