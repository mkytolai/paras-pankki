package com.paras.pankki.account;

import com.paras.pankki.Main;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.client.Client;

public class RestClient implements Helper {

    public RestClient() {
        try {
            Main.main("server", "configuration.yaml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deposit(String customer, Integer balance, String currency) {
        Client jerseyClient = JerseyClientBuilder.createClient();

        jerseyClient
                .target("http://127.0.0.1:4567")
                .path("account")
                .path(customer)
                .path(balance.toString())
                .path(currency)
                .request()
                .get();
    }

    @Override
    public Balance getBalance() {
        Client jerseyClient = JerseyClientBuilder.createClient();

        return jerseyClient
                .target("http://127.0.0.1:4567")
                .path("account/Alma")
                .request()
                .get(Balance.class);
    }
}
