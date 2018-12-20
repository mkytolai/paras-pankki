package com.paras.pankki;

import com.paras.pankki.account.Account;
import com.paras.pankki.account.Balance;
import com.paras.pankki.account.Currency;
import com.paras.pankki.customer.Customer;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Customer, Account> accounts = new HashMap<>();

    public Bank(){}

    public Bank(Customer customer) {
        createAccount(customer);
    }

    public void createAccount(Customer customer) {
        accounts.put(customer, new Account(customer));
    }

    public Balance getBalance(Customer customer) {
        Account account = accounts.get(customer);
        return account.getBalance();
    }

    public void deposit(Account account, Balance balance) {
        Customer customer = account.getCustomer();

        if(accounts.containsKey(customer)){
            Account currentAccount = accounts.get(customer);
            currentAccount.deposit(balance);
        }else{
            accounts.put(customer, account);
            account.deposit(balance);
        }

    }
}
