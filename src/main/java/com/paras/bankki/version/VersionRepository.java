package com.paras.bankki.version;

public class VersionRepository {
    private Version version;

    public VersionRepository() {
        String versionString = getClass().getPackage().getImplementationVersion();
        version = new Version(versionString);
    }

    public VersionRepository(Version version) {
        this.version = version;
    }

    Version getVersion() {
        return version;
    }

    Version getVersionDryRun() {
        return version = new Version("1.0.0");
    }
}
