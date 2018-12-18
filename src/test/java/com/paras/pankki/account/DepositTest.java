package com.paras.pankki.account;

import com.paras.pankki.customer.Customer;
import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DepositTest {

    private Deposit testDeposit = new Deposit(new Balance(25,new Currency("EUR")),new Account(new Customer("Alma")));
    @Test
    public void check_deposit_is_notnull()
    {
        Assert.assertNotNull(testDeposit);
        Assert.assertNotNull(testDeposit.getBalance());
        Assert.assertNotNull(testDeposit.getAccount());
    }

    @Test
    public void check_deposit_is_25_EUR(){
        assertThat(testDeposit.getBalance()).isEqualTo(new Balance(25, new Currency("EUR")));
    }

    @Test
    public void make_sure_alma_is_account_owner() {
        assertThat(testDeposit.getAccount()).isEqualTo(new Account(new Customer("Alma")));
    }

}
