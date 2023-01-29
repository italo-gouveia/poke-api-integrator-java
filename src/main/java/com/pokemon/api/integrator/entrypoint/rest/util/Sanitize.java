package com.pokemon.api.integrator.entrypoint.rest.util;

import com.pokemon.api.integrator.application.dto.PokemonDTO;
import com.pokemon.api.integrator.application.exception.FieldValidatorException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class Sanitize {

    public static final String NUMBER_NOT_ALLOWED = "number not allowed!";
    public static final Character BLANK_CHAR = CharUtils.toChar("");

    private Sanitize(){}

    public static String stringValidate(String param) {
        if(param != null && param.length() > 0) {
            return param.replace('\t', BLANK_CHAR)
                    .replace('\n', BLANK_CHAR)
                    .replace('\r', '_');
        }
        return null;
    }

    public static Long longValidate(Long param) {
        if (param == null) return null;

        if(param < Long.MAX_VALUE && param > Long.MIN_VALUE) {
            return param;
        } else {
            throw new FieldValidatorException(NUMBER_NOT_ALLOWED);
        }
    }

    public static Integer integerValidate(Integer param) {
        if (param == null) {
            return null;
        } else if(param < Integer.MAX_VALUE && param > Integer.MIN_VALUE) {
            return param;
        } else {
            throw new FieldValidatorException(NUMBER_NOT_ALLOWED);
        }
    }

    public static Double doubleValidate(Double param) {
        Double maxValue = 100.0;
        Double minValue = 0.0;
        if (param == null) {
            return null;
        } else if(param >= minValue && param <= maxValue) {
            return param;
        } else {
            throw new FieldValidatorException(NUMBER_NOT_ALLOWED);
        }
    }

    public static Boolean booleanValidate(Boolean param) {
        return (Boolean.FALSE.equals(param) || Boolean.TRUE.equals(param)) ? param : null;
    }

    public static List<String> listValidate (List<String> collection) {
        if(collection == null) return null;

        Optional<List<String>> result = Optional.of(
                collection
                        .stream()
                        .map(Sanitize::stringValidate)
                        .collect(Collectors.toList())
        );
        return result.orElse(null);
    }

    public static PokemonDTO pokemonDTOValidate(PokemonDTO dto) {
        if(dto == null){
            return null;
        }

        dto.setName(stringValidate(dto.getName()));

        return dto;
    }



    public static List<PokemonDTO> listCurationOptionsValidate (List<PokemonDTO> collection) {
        if(collection == null) return null;

        Optional<List<PokemonDTO>> result = Optional.of(
                collection
                        .stream()
                        .map(Sanitize::pokemonDTOValidate)
                        .collect(Collectors.toList())
        );
        return result.orElse(null);
    }


}