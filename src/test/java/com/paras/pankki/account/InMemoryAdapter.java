package com.paras.pankki.account;

import com.paras.pankki.Bank;
import com.paras.pankki.customer.Customer;

public class InMemoryAdapter implements Adapter {

    private Bank bank = new Bank();
    private AccountResource accountResource = new AccountResource(bank);


    @Override
    public void deposit(String customer, Integer balance, String currency) {
        Balance bal = new Balance(balance, new Currency(currency));
        accountResource.deposit(new Customer(customer), bal);
    }

    @Override
    public Balance getBalance(String customer) {
        Customer c = new Customer(customer);
        return accountResource.getBalance(c);
    }

    @Override
    public void withdraw(String customer, Balance balance) {
        Customer cust = new Customer(customer);
        accountResource.withdraw(cust, balance);
    }
}
