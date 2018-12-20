package com.paras.pankki.account;

public interface Helper {

    void deposit(String customer, Integer balance, String currency);
    Balance getBalance();

}
