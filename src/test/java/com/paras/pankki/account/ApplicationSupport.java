package com.paras.pankki.account;

import com.paras.pankki.MainDropwizard;

class ApplicationSupport {

    private static boolean isRunning = false;

    private ApplicationSupport() {
    }

    static void start(String command, String configuration) {
        if (!isRunning) {
            isRunning = Boolean.TRUE;
            try {
                MainDropwizard.main(command, configuration);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
