package com.paras.pankki.account;

import com.paras.pankki.customer.Customer;

import java.util.Objects;

public class Withdrawal {
    private Balance balance;
    private Customer customer;

    Withdrawal() {
        this.balance = new Balance(0, new Currency(""));
        this.customer = new Customer("");
    }

    Withdrawal(Balance balance, Customer customer) {
        this.balance = balance;
        this.customer = customer;
    }

    public Balance getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Withdrawal that = (Withdrawal) o;
        return Objects.equals(balance, that.balance) &&
                Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, customer);
    }
}
