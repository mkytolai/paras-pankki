package com.paras.pankki.version;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("version")
@Produces(MediaType.APPLICATION_JSON)
public class VersionResource {
    private VersionRepository repository;

    public VersionResource(VersionRepository repository) {
        this.repository = repository;
    }

    @GET
    public Version getVersion() {
        return repository.getVersion();
    }
}
