package com.paras.pankki.account;


import com.paras.pankki.customer.Customer;

import java.util.Objects;

public class Deposit {
    private  Customer customer;
    private  Balance balance;

    private Deposit() {
        this.customer = new Customer("");
        this.balance = new Balance(0, new Currency(""));
    }

    Deposit(Balance balance, Customer customer) {
        this.balance = balance;
        this.customer = customer;
    }

    public Balance getBalance() {
        return this.balance;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return Objects.equals(customer, deposit.customer) &&
                Objects.equals(balance, deposit.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, balance);
    }
}
