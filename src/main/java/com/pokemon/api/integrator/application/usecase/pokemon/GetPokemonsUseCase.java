package com.pokemon.api.integrator.application.usecase.pokemon;

import com.pokemon.api.integrator.application.gateway.PokemonGateway;
import com.pokemon.api.integrator.domain.pokemon.Pokemon;
import com.pokemon.api.integrator.entrypoint.rest.vo.PokemonResponseVO;
import com.pokemon.api.integrator.entrypoint.rest.vo.PokemonsResultResponseVO;
import com.pokemon.api.integrator.infrasctructure.feign.PokemonFeignGateway;
import com.pokemon.api.integrator.infrasctructure.feign.presentation.PokemonPresentation;
import com.pokemon.api.integrator.infrasctructure.mapper.pokemon.PokemonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GetPokemonsUseCase {
    private final PokemonFeignGateway gateway;
    private final PokemonMapper mapper;

    public GetPokemonsUseCase(PokemonFeignGateway gateway, PokemonMapper mapper) {
        this.gateway = gateway;
        this.mapper = mapper;
    }

    public PokemonsResultResponseVO execute() {
        PokemonsResultResponseVO pokemonsVO = mapper.mapToVo(gateway.getPokemons());

        log.info("M=getPokemons, message=UseCase, pokemons return successfully, list={}", pokemonsVO);

        return pokemonsVO;
    }
}
