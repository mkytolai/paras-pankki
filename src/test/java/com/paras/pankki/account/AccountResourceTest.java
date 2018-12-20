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
        Deposit deposit = new Deposit(balance, customer);
        accountResource.deposit(deposit);

        verify(bank).deposit(customer, balance);
    }
}
