package com.paras.pankki.account;

import com.paras.pankki.MainSpring;
import org.springframework.boot.SpringApplication;

class ApplicationSupportSpring {

    private static boolean isRunning = false;

    private ApplicationSupportSpring() {
    }

    static void start() {
        if (!isRunning) {
            isRunning = Boolean.TRUE;
            try {
                SpringApplication.run(MainSpring.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
