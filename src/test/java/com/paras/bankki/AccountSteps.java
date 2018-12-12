package com.paras.bankki;

import com.paras.bankki.account.Balance;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class AccountSteps {

    private AccountHelper helper = new AccountHelper();
    private Balance currentBalance;

    @Given("{word} has {int} {word} in her account")
    public void alma_has_EUR_in_her_account(String customer, Integer balance, String currency) {
        helper.deposit(customer, balance, currency);
    }

    @When("she checks her balance")
    public void she_checks_her_balance() {
        currentBalance = helper.getBalance();
    }

    @Then("should she see {int} {word}")
    public void should_she_see_EUR(Integer expected, String currency) {
        assertThat(currentBalance.getBalance()).isEqualTo(expected);
        assertThat(currentBalance.getCurrency()).isEqualTo(currency);
    }
}