package com.paras.pankki.account;

import com.paras.pankki.Bank;
import com.paras.pankki.customer.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class AccountResource {
    private Bank bank;

    public AccountResource(Bank bank) {
        this.bank = bank;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deposit(Deposit deposit) {
        deposit(deposit.getCustomer(), deposit.getBalance());
        return Response.ok(deposit).build();
    }

    void deposit(Customer customer, Balance balance) {
        bank.deposit(customer, balance);
    }

    @GET
    @Path("{user}")
    public Balance getBalance(@PathParam("user") Customer customer) {
        return bank.getBalance(customer);
    }

}
