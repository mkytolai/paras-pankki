package com.paras.bankki;

import com.paras.bankki.version.VersionHealthCheck;
import com.paras.bankki.version.VersionRepository;
import com.paras.bankki.version.VersionResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class Main extends Application<Configuration> {

    public static void main(String... args) throws Exception {
        new Main().run(args);
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
    }
}
