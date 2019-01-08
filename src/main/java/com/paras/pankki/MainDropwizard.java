package com.paras.pankki;

import com.paras.pankki.account.AccountResourceDropwizard;
import com.paras.pankki.account.Bank;
import com.paras.pankki.version.VersionHealthCheck;
import com.paras.pankki.version.VersionRepository;
import com.paras.pankki.version.VersionResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class MainDropwizard extends Application<Configuration> {

    public static void main(String... args) throws Exception {

        new MainDropwizard().run(args);
    }

    @Override
    public String getName() {
        return "Paras pankki";
    }


    @Override
    public void run(Configuration configuration, Environment environment) {
        VersionHealthCheck versionHealthCheck = new VersionHealthCheck();
        environment.healthChecks().register("version", versionHealthCheck);

        VersionRepository versionRepository = new VersionRepository();
        VersionResource version = new VersionResource(versionRepository);
        environment.jersey().register(version);

        AccountResourceDropwizard accountResource = new AccountResourceDropwizard(new Bank());
        environment.jersey().register(accountResource);

    }
}
