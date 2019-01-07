package com.paras.pankki.account;

import com.paras.pankki.Bank;
import com.paras.pankki.customer.Customer;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class AccountResourceTest {

    @Test
    public void should_deposit_25_EUR_to_alma() {
        Balance expected = new Balance(25, new Currency("EUR"));
        Bank bank = new Bank();
        AccountResource accountResource = new AccountResource(bank);


        Customer customer = new Customer("Alma");
        Balance balance = new Balance(25, new Currency("EUR"));

        accountResource.deposit(customer, balance);

        Balance actual = accountResource.getBalance(customer);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void should_deposit_25_EUR_to_alma_ws() {
        Bank bank = mock(Bank.class);

        AccountResource accountResource = new AccountResource(bank);

        Balance balance = new Balance(25, new Currency("EUR"));
        Customer customer = new Customer("Alma");
        Transaction transaction = new Transaction(customer, balance, Transaction.TransactionType.DEPOSIT);
        accountResource.transaction(transaction);

        verify(bank).deposit(customer, balance);
    }
    @Test
    public void should_withdraw_10_EUR_from_alma(){
        Balance expected = new Balance(15, new Currency("EUR"));
        Balance startingBalance = new Balance(25, new Currency("EUR"));
        Bank bank = new Bank();
        AccountResource accountResource = new AccountResource(bank);

        Customer customer = new Customer("Alma");
        Balance toWithdraw = new Balance(10, new Currency("EUR"));

        accountResource.deposit(customer, startingBalance);
        accountResource.withdraw(customer, toWithdraw);

        Balance actual = accountResource.getBalance(customer);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void should_withdraw_10_EUR_from_alma_ws() {
        Bank bank = mock(Bank.class);

        AccountResource accountResource = new AccountResource(bank);

        Balance balance = new Balance(25, new Currency("EUR"));
        Customer customer = new Customer("Alma");
        Transaction startingBalance = new Transaction(customer, balance, Transaction.TransactionType.DEPOSIT);
        accountResource.transaction(startingBalance);

        Balance toWithdraw = new Balance(10, new Currency("EUR"));
        Transaction withdrawal = new Transaction(customer, toWithdraw, Transaction.TransactionType.WITHDRAWAL);
        accountResource.transaction(withdrawal);

        verify(bank).withdraw(customer, toWithdraw);
    }
}
