package com.paras.pankki.account;

import com.paras.pankki.Bank;
import com.paras.pankki.InsufficientFundsException;
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

    void withdraw(Customer customer, Balance balance) {
        bank.withdraw(customer, balance);
    }

    void deposit(Customer customer, Balance balance) {
        bank.deposit(customer, balance);
    }

    @GET
    @Path("{user}")
    public Balance getBalance(@PathParam("user") Customer customer) {
        return bank.getBalance(customer);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response transaction(Transaction transaction) {

        if (transaction.getT() == 0) {
            deposit(transaction.getCustomer(), transaction.getBalance());
            return Response.ok(transaction).build();

        } else if (transaction.getT()==1) {

            try {
                withdraw(transaction.getCustomer(), transaction.getBalance());
            } catch (InsufficientFundsException i) {
                return Response.status(403).entity(i.getMessage()).type(MediaType.TEXT_PLAIN).build();
            }
            return Response.ok(transaction).build();


        } else { // should never get here
            return Response.status(400).build();
        }

    }

}
