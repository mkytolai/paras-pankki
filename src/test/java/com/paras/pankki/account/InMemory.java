package com.paras.pankki.account;

import com.paras.pankki.Bank;
import com.paras.pankki.customer.Customer;

public class InMemory implements Helper {

    private AccountResource accountResource = new AccountResource(new Bank());
    private Customer customer;

    @Override
    public void deposit(String customer, Integer balance, String currency) {
        this.customer = new Customer(customer);
        Account account = new Account(this.customer);

        Balance bal = new Balance(balance, new Currency(currency));
        accountResource.deposit(account.getCustomer(), bal);
    }
    @Override
    public Balance getBalance() {
        return accountResource.getBalance(customer);
    }
}
