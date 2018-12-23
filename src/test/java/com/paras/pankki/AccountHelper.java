package com.paras.pankki;

import com.paras.pankki.account.Balance;
import com.paras.pankki.account.Helper;
import com.paras.pankki.account.InMemory;
import com.paras.pankki.account.RestClient;
import com.paras.pankki.customer.Customer;

class AccountHelper {
    private Helper helper;
    private String currentCustomer;

    AccountHelper()  {
        if (System.getProperty("E2E") != null) {
            helper = new RestClient();
        }
        else{
            helper = new InMemory();
        }
    }

    void deposit(Integer balance, String currency) {
        helper.deposit(currentCustomer, balance, currency);
    }

    void setCurrentCustomer(String currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    Balance getBalance() {
        return helper.getBalance(currentCustomer);
    }
}
