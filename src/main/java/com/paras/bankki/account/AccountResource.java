package com.paras.bankki.account;

import com.paras.bankki.Bank;
import com.paras.bankki.customer.Customer;

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
