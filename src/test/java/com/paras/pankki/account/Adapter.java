package com.paras.pankki.account;


public interface Adapter {

    void deposit(String customer, Integer balance, String currency);

    Balance getBalance(String customer);

    void withdraw(String customer, Balance balance);

}
