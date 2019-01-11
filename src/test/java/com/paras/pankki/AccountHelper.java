package com.paras.pankki;

import com.paras.pankki.account.*;

import static org.assertj.core.api.Assertions.assertThat;

class AccountHelper {
    private Adapter helper;
    private String currentCustomer;
    private Balance currentBalance;

    AccountHelper() {
        helper = new InterfaceAdapter();
        /*
        if (System.getProperty("INT") != null){
            helper = new InterfaceAdapter();
        }
        if (System.getProperty("E2E") != null) {
            helper = new RestClientAdapter();
        } else {
            helper = new InMemoryAdapter();
        }
        */
    }

    void deposit(Integer amount, String currency) {
        helper.deposit(currentCustomer, amount, currency);
    }

    void setCurrentCustomer(String currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    void checkBalance() {
        currentBalance = helper.getBalance(currentCustomer);
    }

    Balance getBalance() {
        return currentBalance;
    }

    void withdraw(Integer amount, String currency) {
        currentBalance = helper.getBalance(currentCustomer); // withdraw might throw exception
        Balance balance = new Balance(amount, new Currency(currency));
        helper.withdraw(currentCustomer, balance);
        currentBalance = helper.getBalance(currentCustomer);
    }

    void assertBalance(Integer expected, String currency) {
        Balance expectedBalance = new Balance(expected, new Currency(currency));

        assertThat(currentBalance).isEqualTo(expectedBalance);
    }
}
