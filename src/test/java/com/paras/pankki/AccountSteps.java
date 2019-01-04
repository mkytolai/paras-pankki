package com.paras.pankki;

import com.paras.pankki.account.Balance;
import com.paras.pankki.account.Currency;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;
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
        helper.getBalance();
    }

    @Then("should she see {int} {word}")
    public void should_she_see_EUR(Integer expected, String currency) {
        Balance expectedBalance = new Balance(expected, new Currency(currency));
        assertThat(helper.getBalance()).isEqualTo(expectedBalance);
        assertThat(helper.getBalance().getCurrency()).isEqualTo(new Currency(currency));
    }

    @Given("she withdraws {int} {word}")
    public void she_withdraws_EUR(Integer amount, String currency) {
        helper.withdraw(amount, currency);
    }

    @Then("she should have {int} {word} in her account")
    public void she_should_have_EUR_in_her_account(Integer amount, String currency) {
        Balance expected = new Balance(amount, new Currency(currency));
        Balance actual = helper.getBalance();

        assertThat(actual).isEqualTo(expected);
    }

    @When("she withdraws {int} {word} it should warn her that she exceeds her funds")
    public void she_withdraws_EUR_it_should_warn_her_that_she_exceeds_her_funds(Integer amount, String currency) {
        assertThatExceptionOfType(InsufficientFundsException.class).isThrownBy(() -> helper.withdraw(amount, currency))
                .withMessage("Insufficient funds, tried to withdraw: 35 had: 25")
                .withNoCause();
    }

}
