package com.pokemon.api.integrator.infrasctructure.feign;

import com.pokemon.api.integrator.infrasctructure.feign.presentation.PokemonPresentation;
import com.pokemon.api.integrator.infrasctructure.feign.presentation.PokemonsResultPresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "pokemonsProviderClientApi",url = "${client.pokemon.url}")
public interface PokemonsProviderClientApi {

    @GetMapping("/pokemon")
    PokemonsResultPresentation getPokemons();
}
