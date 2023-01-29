package com.pokemon.api.integrator.infrasctructure.mapper.pokemon;

import com.pokemon.api.integrator.application.dto.PokemonDTO;
import com.pokemon.api.integrator.application.dto.PokemonDTO.PokemonDTOBuilder;
import com.pokemon.api.integrator.domain.pokemon.Pokemon;
import com.pokemon.api.integrator.domain.pokemon.Pokemon.PokemonBuilder;
import com.pokemon.api.integrator.entrypoint.rest.vo.PokemonResponseVO;
import com.pokemon.api.integrator.entrypoint.rest.vo.PokemonResponseVO.PokemonResponseVOBuilder;
import com.pokemon.api.integrator.entrypoint.rest.vo.PokemonsResultResponseVO;
import com.pokemon.api.integrator.entrypoint.rest.vo.PokemonsResultResponseVO.PokemonsResultResponseVOBuilder;
import com.pokemon.api.integrator.infrasctructure.feign.presentation.PokemonPresentation;
import com.pokemon.api.integrator.infrasctructure.feign.presentation.PokemonsResultPresentation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class PokemonMapperImpl implements PokemonMapper {

    @Override
    public Pokemon map(PokemonPresentation pokemon) {
        if ( pokemon == null ) {
            return null;
        }

        PokemonBuilder pokemon1 = Pokemon.builder();

        pokemon1.name( pokemon.getName() );

        return pokemon1.build();
    }

    @Override
    public Pokemon map(PokemonDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PokemonBuilder pokemon = Pokemon.builder();

        pokemon.name( dto.getName() );

        return pokemon.build();
    }

    @Override
    public PokemonDTO mapToDto(Pokemon pokemon) {
        if ( pokemon == null ) {
            return null;
        }

        PokemonDTOBuilder pokemonDTO = PokemonDTO.builder();

        pokemonDTO.name( pokemon.getName() );

        return pokemonDTO.build();
    }

    @Override
    public PokemonResponseVO map(Pokemon pokemon) {
        if ( pokemon == null ) {
            return null;
        }

        PokemonResponseVOBuilder pokemonResponseVO = PokemonResponseVO.builder();

        pokemonResponseVO.name( pokemon.getName() );

        return pokemonResponseVO.build();
    }

    @Override
    public PokemonsResultResponseVO mapToVo(PokemonsResultPresentation pokemons) {
        if ( pokemons == null ) {
            return null;
        }

        PokemonsResultResponseVOBuilder pokemonsResultResponseVO = PokemonsResultResponseVO.builder();

        pokemonsResultResponseVO.results( pokemonPresentationListToPokemonResponseVOList( pokemons.getResults() ) );

        return pokemonsResultResponseVO.build();
    }

    protected List<PokemonResponseVO> pokemonPresentationListToPokemonResponseVOList(List<PokemonPresentation> list) {
        if ( list == null ) {
            return null;
        }

        List<PokemonResponseVO> list1 = new ArrayList<PokemonResponseVO>( list.size() );
        for ( PokemonPresentation pokemonPresentation : list ) {
            list1.add( map( map( pokemonPresentation ) ) );
        }

        return list1;
    }
}
