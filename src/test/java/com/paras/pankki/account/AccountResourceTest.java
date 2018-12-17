package com.paras.pankki.account;

import com.paras.pankki.Bank;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountResourceTest {

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
        Response actual = resources
                .target("/account/Alma/25/EUR")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertThat(actual.getStatus()).isEqualTo(Response.Status.CREATED.getStatusCode());
    }


}
