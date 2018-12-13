package com.paras.pankki;

import com.paras.pankki.account.Account;
import com.paras.pankki.account.AccountResource;
import com.paras.pankki.account.Balance;
import com.paras.pankki.account.PankkiCurrency;
import com.paras.pankki.customer.Customer;

class AccountHelper {
    private AccountResource accountResource = new AccountResource();
    private Customer customer;

    void deposit(String customer, Integer balance, String currency) {
        this.customer = new Customer(customer);
        Account account = new Account(this.customer);

        Balance bal = new Balance(balance, new PankkiCurrency(currency));
        accountResource.deposit(account, bal);
    }

    Balance getBalance() {
        return accountResource.getBalance(customer);
    }
}
