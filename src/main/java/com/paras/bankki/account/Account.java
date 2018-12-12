package com.paras.bankki.account;

import com.paras.bankki.customer.Customer;

public class Account {
    private Balance balance;
    private Customer customer;

    public Account(Customer customer) {
        this.customer = customer;
    }

    public Balance getBalance() {
        return balance;
    }

    void deposit(Balance balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }
}
