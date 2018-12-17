package com.paras.pankki.account;

import com.paras.pankki.Bank;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountResourceTest {

    private static final Bank tbank = new Bank();

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new AccountResource(tbank))
            .build();

    private Balance bal = new Balance(0, new Currency("EUR"));
    @Test
    public void test_account_balance() {
        Balance actualbalance = resources
                .target("/account/Alma")
                .request()
                .get(Balance.class);

                assertThat(actualbalance.getBalance()).isEqualTo(bal.getBalance());
    }

}
