package com.pokemon.api.integrator.entrypoint.rest.controllers;

import com.pokemon.api.integrator.application.dto.PokemonDTO;
import com.pokemon.api.integrator.application.usecase.pokemon.GetPokemonsUseCase;
import com.pokemon.api.integrator.entrypoint.rest.vo.PokemonResponseVO;
import com.pokemon.api.integrator.entrypoint.rest.vo.PokemonsResultResponseVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/pokemon")
public class PokemonRestController {
    private final GetPokemonsUseCase getPokemonsUseCase;

    public PokemonRestController(GetPokemonsUseCase getPokemonsUseCase) {
        this.getPokemonsUseCase = getPokemonsUseCase;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PokemonsResultResponseVO> getPokemons() {
        log.info("M=getPokemons, message=Controller, request received successfully!");

        PokemonsResultResponseVO pokemons = getPokemonsUseCase.execute();

        log.info("M=getPokemons, message=Controller, Pokemons successfully returned");

        return ResponseEntity.ok(pokemons);
    }
}
