package com.paras.pankki.account;

import com.paras.pankki.Bank;
import com.paras.pankki.customer.Customer;

public class InMemory implements Helper {

    private AccountResource accountResource = new AccountResource(new Bank());
    private Customer customer;

    @Override
    public void deposit(String customer, Integer balance, String currency) {
        this.customer = new Customer(customer);

        Balance bal = new Balance(balance, new Currency(currency));
        accountResource.deposit(new Customer(customer), bal);
    }

    @Override
    public Balance getBalance(String customer) {

        Customer c = new Customer(customer);
        return accountResource.getBalance(c);
    }
}
