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

    @GET
    @Path("{user}")
    public Balance getBalance(@PathParam("user") Customer customer) {
        return bank.getBalance(customer);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response transaction(Transaction transaction) {
        if (transaction.getTransactionType() == Transaction.TransactionType.DEPOSIT) {
            return deposit(transaction);
        }

        if (transaction.getTransactionType() == Transaction.TransactionType.WITHDRAWAL) {
            return withdraw(transaction);
        }

        return Response.status(500).build();
    }

    void deposit(Customer customer, Balance balance) {
        bank.deposit(customer, balance);
    }

    private Response deposit(Transaction transaction) {
        deposit(transaction.getCustomer(), transaction.getBalance());
        return Response.ok(transaction).build();
    }

    void withdraw(Customer customer, Balance balance) {
        bank.withdraw(customer, balance);
    }

    private Response withdraw(Transaction transaction) {
        try {
            withdraw(transaction.getCustomer(), transaction.getBalance());
        } catch (InsufficientFundsException i) {
            return Response.status(403).entity(i.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
        return Response.ok(transaction).build();
    }

}
