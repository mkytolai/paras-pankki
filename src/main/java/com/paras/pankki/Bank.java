package com.paras.pankki;

import com.paras.pankki.account.Account;
import com.paras.pankki.account.Balance;
import com.paras.pankki.customer.Customer;

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
