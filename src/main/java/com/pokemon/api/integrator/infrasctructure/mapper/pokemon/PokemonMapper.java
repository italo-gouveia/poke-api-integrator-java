package com.pokemon.api.integrator.infrasctructure.mapper.pokemon;

import com.pokemon.api.integrator.application.dto.PokemonDTO;
import com.pokemon.api.integrator.entrypoint.rest.vo.PokemonResponseVO;
import com.pokemon.api.integrator.domain.pokemon.Pokemon;
import com.pokemon.api.integrator.entrypoint.rest.vo.PokemonsResultResponseVO;
import com.pokemon.api.integrator.infrasctructure.feign.presentation.PokemonPresentation;
import com.pokemon.api.integrator.infrasctructure.feign.presentation.PokemonsResultPresentation;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface PokemonMapper {

    Pokemon map(PokemonPresentation pokemon);

    Pokemon map(PokemonDTO dto);

    //PokemonPresentation map(Pokemon pokemon);

    PokemonDTO mapToDto(Pokemon pokemon);

    //PokemonResponseVO mapToVo(Pokemon pokemon);

    PokemonResponseVO map(Pokemon pokemon);

    PokemonsResultResponseVO mapToVo(PokemonsResultPresentation pokemons);

}
