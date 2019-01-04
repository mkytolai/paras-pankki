package com.paras.pankki.account;

import com.paras.pankki.InsufficientFundsException;
import com.paras.pankki.InsufficientWebFundsException;
import com.paras.pankki.customer.Customer;
import org.glassfish.jersey.client.JerseyClientBuilder;
import sun.tools.jar.CommandLine;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class RestClientAdapter implements Adapter {

    public RestClientAdapter() {
        ApplicationSupport.start("server", "configuration.yaml");
    }

    @Override
    public void deposit(String customer, Integer balance, String currency) {
        Client jerseyClient = JerseyClientBuilder.createClient();
        Deposit testDeposit = new Deposit(new Balance(balance, new Currency(currency)), new Customer(customer));

        jerseyClient
                .target("http://127.0.0.1:4567")
                .path("account")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(testDeposit));
    }

    @Override
    public Balance getBalance(String user) {
        Client jerseyClient = JerseyClientBuilder.createClient();
        return jerseyClient
                .target("http://127.0.0.1:4567")
                .path("account/" + user)
                .request()
                .get(Balance.class);
    }

    @Override
    public void withdraw(String customer, Balance balance) throws InsufficientFundsException {
        Client jerseyClient = JerseyClientBuilder.createClient();
        Withdrawal testWithdrawal = new Withdrawal(balance, new Customer(customer));

        if (
                jerseyClient
                        .target("http://127.0.0.1:4567")
                        .path("account/w")
                        .request(MediaType.APPLICATION_JSON)
                        .post(Entity.json(testWithdrawal))
                        .getStatus()
                        ==
                        403
        ) {
            throw new InsufficientFundsException("test");
        }

    }
}