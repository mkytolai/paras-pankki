package com.paras.pankki.account;

import com.paras.pankki.InsufficientFundsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private List<Balance> balance;

    public Account() {
    }

    public Balance getBalance() {
        return currentBalance();
    }

    public void deposit(Balance balance) {
        if (this.balance == null) {
            this.balance = new ArrayList<>();
        }
        this.balance.add(balance);
    }

    private Balance currentBalance() {
        Integer temp = 0;
        for (Balance i : balance) {
            temp += i.getBalance();
        }
        return new Balance(temp, new Currency("EUR"));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

    public void withdraw(Balance balance) throws InsufficientFundsException {
        //TODO: add comparison/sorting method to Balance, this ignores currency
        if (balance.getBalance() > currentBalance().getBalance()) {
            throw new InsufficientFundsException("Insufficient funds, tried to withdraw: "+balance.getBalance()+
                    " had: "+currentBalance().getBalance());
        }else{
            Integer withdrawAmount = balance.getBalance() * -1;
            Balance withdrawBalance = new Balance(withdrawAmount, balance.getCurrency());
            this.balance.add(withdrawBalance);
        }
    }
}
