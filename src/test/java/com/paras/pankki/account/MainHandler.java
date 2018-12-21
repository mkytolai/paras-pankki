package com.paras.pankki.account;

import com.paras.pankki.Main;

class MainHandler {

    private static boolean isRunning = false;
    private MainHandler(){}

    static void start(String command, String configuration) {
        if(!isRunning){
            isRunning = Boolean.TRUE;
            try {
                Main.main(command, configuration);
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
