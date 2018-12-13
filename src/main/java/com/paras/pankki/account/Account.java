package com.paras.pankki.account;

import com.paras.pankki.customer.Customer;

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
