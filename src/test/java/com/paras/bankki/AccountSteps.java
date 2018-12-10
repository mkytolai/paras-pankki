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
    private String c;

    @Given("{word} has {int} EUR in her account")
    public void alma_has_EUR_in_her_account(String customer, Integer balance) {
        Account a = new Account();
        Balance bal = new Balance(balance, "EUR");
        c = customer;
        a.setBalance(bal);
        b.createAccount(customer, a);

    }

    @When("she checks her balance")
    public void she_checks_her_balance() {
        currentBalance = b.getBalance(c);
    }

    @Then("should she see {int} {word}")
    public void should_she_see_EUR(Integer expected, String currency) {
        assertThat(currentBalance.getBalance()).isEqualTo(expected);
        assertThat(currentBalance.getCurrency()).isEqualTo(currency);
    }


}
