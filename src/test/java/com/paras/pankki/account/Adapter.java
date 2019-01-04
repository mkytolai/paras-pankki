package com.paras.pankki.account;


import com.paras.pankki.InsufficientFundsException;

public interface Adapter {

    void deposit(String customer, Integer balance, String currency);
    Balance getBalance(String customer);

    void withdraw(Balance balance) throws InsufficientFundsException;

}
