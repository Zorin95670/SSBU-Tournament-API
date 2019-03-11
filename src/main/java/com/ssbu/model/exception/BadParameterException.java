package com.ssbu.model.exception;

import javax.ws.rs.core.Response.Status;

public class BadParameterException extends ControllerException {

    /**
     *
     */
    private static final long serialVersionUID = -8476826033360738888L;

    public BadParameterException(final Class<?> clazz, final String field, final String value) {
        super(Status.BAD_REQUEST);
        this.setMessage(String.format("Bad %s %s: %s", clazz.getSimpleName(), field, value));
    }
}
