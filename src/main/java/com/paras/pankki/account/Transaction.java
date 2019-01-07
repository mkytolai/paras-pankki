package com.paras.pankki.account;

import com.paras.pankki.customer.Customer;

import java.util.Objects;

public class Transaction {

    public enum TransactionType {
        WITHDRAWAL,
        DEPOSIT
    }

    private Customer customer;
    private Balance balance;
    private TransactionType transactionType;

    public Transaction() {
        this.customer = new Customer("");
        this.balance = new Balance(0, new Currency(""));
        this.transactionType = TransactionType.DEPOSIT;
    }

    Transaction(Customer customer, Balance balance, TransactionType transactionType) {
        this.customer = customer;
        this.balance = balance;
        this.transactionType = transactionType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Balance getBalance() {
        return balance;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(customer, that.customer) &&
                Objects.equals(balance, that.balance) &&
                transactionType == that.transactionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, balance, transactionType);
    }
}
