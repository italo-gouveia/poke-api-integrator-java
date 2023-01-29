package com.pokemon.api.integrator.infrasctructure.feign.presentation;

import com.pokemon.api.integrator.domain.pokemon.Pokemon;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
//entity se for salvar em banco
public class PokemonsResultPresentation {
    List<PokemonPresentation> results;
    Integer count;
    String next;
    String previous;

}
