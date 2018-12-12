package com.paras.bankki;

import com.paras.bankki.account.Account;
import com.paras.bankki.account.AccountResource;
import com.paras.bankki.account.Balance;
import com.paras.bankki.customer.Customer;

class AccountHelper {
    private AccountResource accountResource = new AccountResource();
    private Customer customer;

    void deposit(String customer, Integer balance, String currency) {
        this.customer = new Customer(customer);
        Account account = new Account(this.customer);

        Balance bal = new Balance(balance, currency);
        accountResource.deposit(account, bal);
    }

    Balance getBalance() {
        return accountResource.getBalance(customer);
    }
}
