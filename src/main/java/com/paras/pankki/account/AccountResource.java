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

    @GET
    @Path("{customer}/{amount}/{currency}")
    public Response deposit(@PathParam("customer") String customer,
                         @PathParam("amount") Integer amount,
                         @PathParam("currency")String currency) {
        Account account = new Account(new Customer(customer));
        Balance balance = new Balance(amount, new Currency(currency));

        deposit(account, balance);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deposit(Deposit deposit) {
        deposit(deposit.getAccount(), deposit.getBalance());
        return Response.ok(deposit).build();
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
