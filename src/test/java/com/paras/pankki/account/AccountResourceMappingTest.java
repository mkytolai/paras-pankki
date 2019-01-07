package com.paras.pankki.account;

import com.paras.pankki.Bank;
import com.paras.pankki.customer.Customer;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountResourceMappingTest {

    private final Bank bank = new Bank((new Customer("Alma")));
    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new AccountResource(bank))
            .build();


    @Test
    public void should_deposit_25_EUR_to_Alma_and_check_account() {

        Balance expected = new Balance(25, new Currency("EUR"));

        Deposit testDeposit = new Deposit(new Balance(25, new Currency("EUR")), new Customer("Alma"));

        Response response = resources
                .target("/account/d")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(testDeposit));


        assertThat(response.getStatus()).isEqualTo(Response.ok().build().getStatus());

        Balance actual = resources
                .target("/account/Alma")
                .request()
                .get(Balance.class);

        assertThat(actual).isEqualTo(expected);


    }
    //TODO add withdraw

}
