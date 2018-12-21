package com.paras.pankki;

import com.paras.pankki.account.Balance;
import com.paras.pankki.account.Currency;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class AccountSteps {

    private AccountHelper helper = new AccountHelper();
    private Balance currentBalance;

    @Given("{word} has {int} {word} in her account")
    public void user_has_EUR_in_her_account(String customer, Integer amount, String currency) {
        helper.deposit(customer, amount, currency);
    }

    @Given("{word} deposits {int} {word}")
    public void user_deposits_EUR(String customer, Integer amount, String currency) {
        helper.deposit(customer, amount, currency);
    }

    @When("{word} checks her balance")
    public void she_checks_her_balance(String customer) {
        currentBalance = helper.getBalance(customer);
    }

    @Then("should she see {int} {word}")
    public void should_she_see_EUR(Integer expected, String currency) {
        assertThat(currentBalance.getBalance()).isEqualTo(expected);
        assertThat(currentBalance.getCurrency()).isEqualTo(new Currency(currency));
    }


}
