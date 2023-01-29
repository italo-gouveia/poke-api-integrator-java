package com.pokemon.api.integrator.application.translator;

import com.pokemon.api.integrator.application.dto.PokemonDTO;
import com.pokemon.api.integrator.entrypoint.rest.vo.PokemonResponseVO;
import com.pokemon.api.integrator.domain.pokemon.Pokemon;
import com.pokemon.api.integrator.entrypoint.rest.vo.PokemonsResultResponseVO;
import com.pokemon.api.integrator.infrasctructure.feign.presentation.PokemonsResultPresentation;
import com.pokemon.api.integrator.infrasctructure.mapper.pokemon.PokemonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class PokemonTranslator {
    private final PokemonMapper pokemonMapper;

    public PokemonTranslator(PokemonMapper pokemonMapper) {
        this.pokemonMapper = pokemonMapper;
    }

    public Pokemon translate(PokemonDTO dto) {
        return pokemonMapper.map(dto);
    }

//    public PokemonResponseVO translateVO(Pokemon recommendation) {
//        return pokemonMapper.mapToVo(recommendation);
//    }

//    public List<PokemonResponseVO> translateListVO(List<Pokemon> pokemon) {
//        if (pokemon == null)
//            return Collections.emptyList();
//        return pokemon.stream().map(this::translateVO).collect(Collectors.toList());
//    }

    public PokemonDTO translate(Pokemon pokemon) {
        return pokemonMapper.mapToDto(pokemon);
    }

    public PokemonsResultResponseVO translate(PokemonsResultPresentation presentation) {
        return pokemonMapper.mapToVo(presentation);
    }
}
