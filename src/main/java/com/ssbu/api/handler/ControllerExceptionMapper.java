package com.ssbu.api.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.ssbu.model.exception.ControllerException;

@Provider
public class ControllerExceptionMapper implements ExceptionMapper<ControllerException> {

    @Override
    public Response toResponse(final ControllerException exception) {
        return exception.getResponse();
    }

}
