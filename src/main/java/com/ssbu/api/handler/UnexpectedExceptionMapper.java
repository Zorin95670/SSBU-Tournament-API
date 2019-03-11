package com.ssbu.api.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

//@Provider
public class UnexpectedExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(final Throwable exception) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Internal server error.").type("text/plain")
                .build();
    }

}
