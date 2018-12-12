package com.paras.bankki;

import com.paras.bankki.account.Account;
import com.paras.bankki.account.Balance;
import com.paras.bankki.customer.Customer;

class AccountHelper {
    private Customer customer;
    private Bank bank = new Bank();

    void deposit(String customer, Integer balance, String currency) {
        Account account = new Account();
        this.customer = new Customer(customer);

        Balance bal = new Balance(balance, currency);
        account.deposit(bal);

        bank.createAccount(this.customer, account);
    }

    Balance getBalance() {
        return bank.getBalance(customer);
    }
}
