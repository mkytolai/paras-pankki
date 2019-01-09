package com.paras.pankki.account;

import com.paras.pankki.Main;
import org.springframework.boot.SpringApplication;

class ApplicationSupport {

    private static boolean isRunning = false;

    private ApplicationSupport() {
    }

    static void start() {
        if (!isRunning) {
            isRunning = Boolean.TRUE;
            try {
                SpringApplication.run(Main.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
