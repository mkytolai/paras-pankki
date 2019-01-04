package com.paras.pankki;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class InsufficientWebFundsException extends WebApplicationException {
    public InsufficientWebFundsException() {
        super(Response.status(403).build());
    }

    public InsufficientWebFundsException(String message) {
        super(Response.status(403).entity(message).type("text/plain").build());
    }
}
