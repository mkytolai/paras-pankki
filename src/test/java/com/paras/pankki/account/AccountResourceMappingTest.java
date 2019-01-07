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

        Transaction testTransaction = new Transaction(new Customer("Alma"), new Balance(25, new Currency("EUR")), Transaction.TransactionType.DEPOSIT);

        Response response = resources
                .target("/account/")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(testTransaction));


        assertThat(response.getStatus()).isEqualTo(Response.ok().build().getStatus());

        Balance actual = resources
                .target("/account/Alma")
                .request()
                .get(Balance.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void should_withdraw_10_EUR_from_Alma_and_verify() {
        Balance expected = new Balance(15, new Currency("EUR"));
        Transaction startingBalance = new Transaction(new Customer("Alma"), new Balance(25, new Currency("EUR")), Transaction.TransactionType.DEPOSIT);

        Response depositResponse = resources
                .target("/account")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(startingBalance));

        assertThat(depositResponse.getStatus()).isEqualTo(Response.ok().build().getStatus());

        Transaction withdrawal = new Transaction(new Customer("Alma"), new Balance(10, new Currency("EUR")), Transaction.TransactionType.WITHDRAWAL);

        Response withdrawResponse = resources
                .target("/account")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(withdrawal));

        assertThat(withdrawResponse.getStatus()).isEqualTo(Response.ok().build().getStatus());

        Balance actual = resources.target("/account/Alma").request().get(Balance.class);

        assertThat(actual).isEqualTo(expected);
    }


}
