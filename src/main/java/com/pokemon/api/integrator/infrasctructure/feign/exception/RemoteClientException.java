package com.pokemon.api.integrator.infrasctructure.feign.exception;


import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.http.HttpStatus;

@Value
@EqualsAndHashCode(callSuper = true)
public class RemoteClientException extends RuntimeException {
    private final HttpStatus status;
    private final String message;
}