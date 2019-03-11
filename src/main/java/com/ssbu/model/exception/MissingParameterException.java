package com.ssbu.model.exception;

import javax.ws.rs.core.Response.Status;

public class MissingParameterException extends ControllerException {

    /**
     *
     */
    private static final long serialVersionUID = -1314598471840035624L;

    public MissingParameterException(final String name) {
        super(Status.BAD_REQUEST);
        this.setMessage(String.format("Missing parameter: %s", name));
    }
}
