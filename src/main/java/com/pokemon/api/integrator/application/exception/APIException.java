package com.pokemon.api.integrator.application.exception;

import org.apache.commons.lang3.StringUtils;

public abstract class APIException extends RuntimeException {
    private final ExceptionType type;

    public APIException(ExceptionType type) { this(type, StringUtils.EMPTY); }

    public APIException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public ExceptionType getType() { return type; }
}
