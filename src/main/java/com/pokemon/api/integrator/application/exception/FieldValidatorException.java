package com.pokemon.api.integrator.application.exception;

public class FieldValidatorException extends APIException {
    public FieldValidatorException(String message) {
        this(ExceptionType.FIELD_VALIDATOR_ERROR, message);
    }

    public FieldValidatorException(ExceptionType type, String message){
        super(type, message);
    }
}
