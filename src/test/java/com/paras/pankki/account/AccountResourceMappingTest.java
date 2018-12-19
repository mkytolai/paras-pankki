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

    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new AccountResource(new Bank()))
            .build();

    @Test
    public void test_account_balance() {
        Balance expected = new Balance(0, new Currency("EUR"));

        Balance actual = resources
                .target("/account/Alma")
                .request()
                .get(Balance.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void should_deposit_25_EUR_to_Alma() {

        Deposit testDeposit = new Deposit(new Balance(25, new Currency("EUR")), new Account(new Customer("Alma")));

        Response response = resources
                .target("/account")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(testDeposit));


        assertThat(response.getStatus()).isEqualTo(Response.ok().build().getStatus());

    }

}
