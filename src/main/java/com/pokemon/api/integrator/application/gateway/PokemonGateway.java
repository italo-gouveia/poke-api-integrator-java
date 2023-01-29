package com.pokemon.api.integrator.application.gateway;

import com.pokemon.api.integrator.infrasctructure.feign.presentation.PokemonsResultPresentation;

public interface PokemonGateway {
    PokemonsResultPresentation getPokemons();
}
