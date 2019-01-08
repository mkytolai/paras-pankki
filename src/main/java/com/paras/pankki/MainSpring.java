package com.paras.pankki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.paras.pankki.account.Bank"})
public class MainSpring {
    public static void main(String[] args){
        SpringApplication.run(MainSpring.class, args);
    }
}
