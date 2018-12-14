package com.paras.pankki.account;

import com.paras.pankki.customer.Customer;

public class InMemory implements Helper {

    private AccountResource accountResource = new AccountResource();
    private Customer customer;

    @Override
    public void deposit(String customer, Integer balance, String currency) {
        this.customer = new Customer(customer);
        Account account = new Account(this.customer);

        Balance bal = new Balance(balance, new PankkiCurrency(currency));
        accountResource.deposit(account, bal);
    }
    @Override
    public Balance getBalance() {
        return accountResource.getBalance(customer);
    }
}
