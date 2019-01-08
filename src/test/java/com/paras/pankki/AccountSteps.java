package com.paras.pankki;

import com.paras.pankki.account.InsufficientFundsException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class AccountSteps {

    private AccountHelper helper = new AccountHelper();

    @Given("{word} has {int} {word} in her account")
    public void user_has_EUR_in_her_account(String customer, Integer amount, String currency) {
        helper.setCurrentCustomer(customer);
        helper.deposit(amount, currency);
    }

    @Given("she deposits {int} {word}")
    public void user_deposits_EUR(Integer amount, String currency) {
        helper.deposit(amount, currency);
    }

    @When("she checks her balance")
    public void she_checks_her_balance() {
        helper.checkBalance();
    }

    @Then("should she see {int} {word}")
    public void should_she_see_EUR(Integer amount, String currency) {
        helper.assertBalance(amount, currency);
    }

    @When("she withdraws {int} {word}")
    public void she_withdraws_EUR(Integer amount, String currency) {
        helper.withdraw(amount, currency);
    }

    @Then("she should have {int} {word} in her account")
    public void she_should_have_EUR_in_her_account(Integer amount, String currency) {
        helper.assertBalance(amount, currency);
    }

    @When("she tries to withdraw {int} {word} she should be informed that she exceeds her funds")
    public void she_tries_to_withdraw_EUR_she_should_be_informed_that_she_exceeds_her_funds(Integer amount, String currency) {
        assertThatExceptionOfType(InsufficientFundsException.class).isThrownBy(() -> helper.withdraw(amount, currency))
                .withMessage("Insufficient funds, tried to withdraw: 35 had: 25")
                .withNoCause();
    }

    @When("her balance should still be {int} {word}")
    public void her_balance_should_still_be_EUR(Integer amount, String currency) {
        helper.assertBalance(amount, currency);
    }

}
