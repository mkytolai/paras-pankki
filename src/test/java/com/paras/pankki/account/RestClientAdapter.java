package com.paras.pankki.account;

import com.paras.pankki.InsufficientFundsException;
import com.paras.pankki.customer.Customer;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClientAdapter implements Adapter {

    public RestClientAdapter() {
        ApplicationSupport.start("server", "configuration.yaml");
    }

    @Override
    public void deposit(String customer, Integer balance, String currency) {
        Client jerseyClient = JerseyClientBuilder.createClient();
        Customer testCustomer = new Customer(customer);
        Balance testBalance = new Balance(balance, new Currency(currency));
        Transaction transaction = new Transaction(testCustomer, testBalance, Transaction.TransactionType.DEPOSIT);

        jerseyClient
                .target("http://127.0.0.1:4567")
                .path("account")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(transaction));
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
    public void withdraw(String customer, Balance balance) {
        Client jerseyClient = JerseyClientBuilder.createClient();
        Customer testCustomer = new Customer(customer);
        Transaction testTransaction = new Transaction(testCustomer, balance, Transaction.TransactionType.WITHDRAWAL);

        Response response = jerseyClient
                .target("http://127.0.0.1:4567")
                .path("account")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(testTransaction));

        if (response.getStatus() == 403) {
            String message = response.readEntity(String.class);
            throw new InsufficientFundsException(message);
        }
    }
}
