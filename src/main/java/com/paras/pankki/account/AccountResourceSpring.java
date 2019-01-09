package com.paras.pankki.account;

import com.paras.pankki.customer.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/account")
public class AccountResourceSpring {

    private Bank bank;

    private AccountResourceSpring() {
        bank = new Bank();
    }

    public AccountResourceSpring(Bank bank){
        this.bank = bank;
    }

    @RequestMapping(value = "/{customer}", method = GET)
    public Balance getBalance(@PathVariable("customer") Customer customer) {
        return bank.getBalance(customer);
    }

    @PostMapping
    public ResponseEntity<String> transaction(@RequestBody Transaction transaction) {


        if (transaction.getTransactionType() == Transaction.TransactionType.DEPOSIT) {
            return deposit(transaction);
        }
        if (transaction.getTransactionType() == Transaction.TransactionType.WITHDRAWAL) {
            return withdraw(transaction);
        }

        return ResponseEntity.status(403).body(transaction.toString());
    }

    private ResponseEntity<String> deposit(Transaction transaction) {
        deposit(transaction.getCustomer(), transaction.getBalance());

        return ResponseEntity.status(HttpStatus.OK).body(transaction.toString());
    }
    void deposit(Customer customer, Balance balance) {
        bank.deposit(customer, balance);
    }

    private ResponseEntity<String> withdraw(Transaction transaction) {
        try {
            withdraw(transaction.getCustomer(), transaction.getBalance());
        } catch (InsufficientFundsException i) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(i.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(transaction.toString());
    }
    void withdraw(Customer customer, Balance balance) {
        bank.withdraw(customer, balance);
    }
}
