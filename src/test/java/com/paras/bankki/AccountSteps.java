package com.paras.bankki;

import com.paras.bankki.account.Account;
import com.paras.bankki.account.Balance;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class AccountSteps {

    private Bank b = new Bank();
    private Balance currentBalance;

    @Given("{string} has {int} EUR in her account")
    public void alma_has_EUR_in_her_account(String customer, Integer balance) {
        Account a = new Account();
        Balance bal = new Balance(balance, "EUR");
        a.setBalance(bal);
        b.createAccount(customer, a);

    }

    @When("{string} checks her balance")
    public void alma_checks_her_balance(String customer) {
        currentBalance = b.getBalance(customer);
    }

    @Then("should she see {int} EUR")
    public void should_she_see_EUR(Integer expected) {
        assertThat(currentBalance.getBalance()).isEqualTo(expected);
        assertThat(currentBalance.getCurrency()).isEqualTo("EUR");
    }


}
