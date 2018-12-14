package com.paras.pankki.account;

import com.paras.pankki.Bank;
import com.paras.pankki.customer.Customer;


public class AccountResource {
    private Bank bank = new Bank();
    public void deposit(Account account, Balance balance) {
        bank.createAccount(account);
        account.deposit(balance);
    }

    public Balance getBalance(Customer customer) {
        return bank.getBalance(customer);
    }
}
