package com.pokemon.api.integrator.infrasctructure.configuration;

import com.pokemon.api.integrator.PokemonApiIntegrator;
import com.pokemon.api.integrator.infrasctructure.feign.exception.RemoteClientException;
import com.pokemon.api.integrator.infrasctructure.feign.exception.RemoteServerException;

import feign.Logger;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@Configuration
@EnableFeignClients(basePackageClasses = PokemonApiIntegrator.class)
public class FeignConfiguration {
    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {
            final String body = parseFeignBody(response);
            final String errorMessage = String.format("Error on execute remote call %s%nResponse body:%n %s",
                    methodKey, body);

            log.error("Error on execute remote call {}\nResponse status: {}\nResponse body:\n {}",
                    methodKey, response.status(), body);

            final HttpStatus status = HttpStatus.valueOf(response.status());
            if (status.is4xxClientError()) {
                return new RemoteClientException(status, errorMessage);
            }
            return new RemoteServerException(errorMessage);
        };
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    private static String parseFeignBody(final Response response) {
        if (Objects.nonNull(response.body())) {
            try {
                return Util.toString(response.body().asReader());
            } catch (IOException e) {
                log.error("Error to parse response body", e);
            }
        }
        return null;
    }
}