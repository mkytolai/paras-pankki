package com.paras.pankki.account;

import com.paras.pankki.customer.Customer;

import java.util.Objects;

public class Account {
    private Balance balance;
    private Customer customer;

    private Account() {
    }

    public Account(Customer customer) {
        this.customer = customer;
    }

    public Balance getBalance() {
        return balance;
    }

    public void deposit(Balance balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(balance, account.balance) &&
                Objects.equals(customer, account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, customer);
    }
}
