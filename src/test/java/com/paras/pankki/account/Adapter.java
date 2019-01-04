package com.paras.pankki.account;


import com.paras.pankki.InsufficientFundsException;
import com.paras.pankki.InsufficientWebFundsException;

public interface Adapter {

    void deposit(String customer, Integer balance, String currency);
    Balance getBalance(String customer);

    void withdraw(String customer, Balance balance);

}
