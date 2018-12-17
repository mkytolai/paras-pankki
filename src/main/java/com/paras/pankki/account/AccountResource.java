package com.paras.pankki.account;

import com.paras.pankki.Bank;
import com.paras.pankki.customer.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class AccountResource {
    private Bank bank;

    public AccountResource(Bank bank) {
        this.bank = bank;
    }

    void deposit(Account account, Balance balance) {
        bank.createAccount(account);
        account.deposit(balance);
    }

    @GET
    @Path("{user}")
    public Balance getBalance(@PathParam("user") Customer customer) {
        return bank.getBalance(customer);
    }

}
