package com.pokemon.api.integrator.infrasctructure.feign;

import com.pokemon.api.integrator.application.gateway.PokemonGateway;
import com.pokemon.api.integrator.domain.pokemon.Pokemon;
import com.pokemon.api.integrator.infrasctructure.feign.presentation.PokemonPresentation;
import com.pokemon.api.integrator.infrasctructure.feign.presentation.PokemonsResultPresentation;
import com.pokemon.api.integrator.infrasctructure.mapper.pokemon.PokemonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class PokemonFeignGateway implements PokemonGateway {
    private final PokemonsProviderClientApi client;
    private final PokemonMapper mapper;

    public PokemonFeignGateway(PokemonsProviderClientApi client, PokemonMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public PokemonsResultPresentation getPokemons() {
        PokemonsResultPresentation resultPokemons;

        resultPokemons = client.getPokemons();

        return resultPokemons;//.stream().map(mapper::map).collect(Collectors.toList());
    }

}
