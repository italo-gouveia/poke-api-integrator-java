package com.pokemon.api.integrator.infrasctructure.feign.exception;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class RemoteServerException extends RuntimeException {
    private final String message;
}