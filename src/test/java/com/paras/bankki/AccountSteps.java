package com.paras.bankki;

import com.paras.bankki.account.Account;
import com.paras.bankki.account.Balance;
import com.paras.bankki.customer.Customer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class AccountSteps {

    private Bank bank = new Bank();
    private Balance currentBalance;
    private Customer customer;

    @Given("{word} has {int} {word} in her account")
    public void alma_has_EUR_in_her_account(String customer, Integer balance, String currency) {
        Account account = new Account();
        Balance bal = new Balance(balance, currency);
        this.customer = new Customer(customer);
        account.setBalance(bal);
        bank.createAccount(this.customer, account);

    }

    @When("she checks her balance")
    public void she_checks_her_balance() {
        currentBalance = bank.getBalance(customer);
    }

    @Then("should she see {int} {word}")
    public void should_she_see_EUR(Integer expected, String currency) {
        assertThat(currentBalance.getBalance()).isEqualTo(expected);
        assertThat(currentBalance.getCurrency()).isEqualTo(currency);
    }


}
