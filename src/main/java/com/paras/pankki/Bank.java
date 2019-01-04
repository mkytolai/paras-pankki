package com.paras.pankki;

import com.paras.pankki.account.Account;
import com.paras.pankki.account.Balance;
import com.paras.pankki.customer.Customer;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Customer, Account> accounts = new HashMap<>();

    public Bank() {
    }

    public Bank(Customer customer) {
        createAccount(customer);
    }

    private void createAccount(Customer customer) {
        accounts.put(customer, new Account());
    }

    public Balance getBalance(Customer customer) {
        Account account = accounts.get(customer);
        return account.getBalance();
    }

    public Account getAccount(Customer customer) {
        return accounts.get(customer);
    }

    public void deposit(Customer customer, Balance balance) {

        if (accounts.containsKey(customer)) {
            Account currentAccount = accounts.get(customer);
            currentAccount.deposit(balance);
        } else {
            createAccount(customer);
            Account currentAccount = accounts.get(customer);
            currentAccount.deposit(balance);
        }
    }

    public void withdraw(Customer customer, Balance balance){
        Account currentAccount = accounts.get(customer);

        currentAccount.withdraw(balance);
    }
}
