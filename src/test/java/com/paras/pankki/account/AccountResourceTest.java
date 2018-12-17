package com.paras.pankki.account;

import com.paras.pankki.Bank;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountResourceTest {

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
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

}
