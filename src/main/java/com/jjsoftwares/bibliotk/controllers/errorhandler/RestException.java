package com.jjsoftwares.bibliotk.controllers.errorhandler;

public class RestException extends RuntimeException {
    public RestException(String message) {
        super(message);
    }
}
