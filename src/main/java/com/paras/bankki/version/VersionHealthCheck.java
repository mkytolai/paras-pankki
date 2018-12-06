package com.paras.bankki.version;

import com.codahale.metrics.health.HealthCheck;

public class VersionHealthCheck extends HealthCheck {
    @Override
    protected Result check() {
        VersionRepository repository = new VersionRepository();

        if (repository.getVersion() == null) {
            return Result.unhealthy("Can't find the version");
        }

        return Result.healthy();
    }
}
