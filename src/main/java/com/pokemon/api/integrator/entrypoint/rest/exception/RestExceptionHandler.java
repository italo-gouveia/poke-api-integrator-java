package com.pokemon.api.integrator.entrypoint.rest.exception;

import com.pokemon.api.integrator.application.exception.FieldValidatorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(FieldValidatorException.class)
    protected ResponseEntity<String> handleFieldValidatorException(FieldValidatorException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
