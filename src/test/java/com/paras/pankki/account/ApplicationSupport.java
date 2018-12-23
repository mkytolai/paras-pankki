package com.paras.pankki.account;

import com.paras.pankki.Main;

class ApplicationSupport {

    private static boolean isRunning = false;

    private ApplicationSupport() {
    }

    static void start(String command, String configuration) {
        if (!isRunning) {
            isRunning = Boolean.TRUE;
            try {
                Main.main(command, configuration);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
