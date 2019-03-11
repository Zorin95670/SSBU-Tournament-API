package com.ssbu.model.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ControllerException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -7286025596467497367L;

    private Status status;
    private String message;
    private String Type = "text/plain";

    public ControllerException(final Status status) {
        this.setStatus(status);
    }

    public Response getResponse() {
        return Response.status(this.getStatus()).entity(this.getMessage()).type(this.getType()).build();
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public String getType() {
        return this.Type;
    }

    public void setType(final String type) {
        this.Type = type;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

}
