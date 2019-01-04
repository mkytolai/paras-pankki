package com.paras.pankki.account;

import com.paras.pankki.customer.Customer;

import java.util.Objects;

public class Transaction {

    enum TransactionType {
        WITHDRAWAL,
        DEPOSIT
    }

    private Customer customer;
    private Balance balance;
    private TransactionType t;

    public Transaction() {
    }

    public Transaction(Customer customer, Balance balance, TransactionType t) {
        this.customer = customer;
        this.balance = balance;
        this.t = t;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Balance getBalance() {
        return balance;
    }

    public TransactionType getTransactionType() {
        return t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(customer, that.customer) &&
                Objects.equals(balance, that.balance) &&
                t == that.t;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, balance, t);
    }
}
