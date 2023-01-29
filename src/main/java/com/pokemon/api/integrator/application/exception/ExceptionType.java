package com.pokemon.api.integrator.application.exception;

public enum ExceptionType {
    UNMAPPED_ERROR(0, "Unmapped Error!"),
    FIELD_VALIDATOR_ERROR(1, "Field Validation error");

    private final Integer id;
    private final String message;

    ExceptionType(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
