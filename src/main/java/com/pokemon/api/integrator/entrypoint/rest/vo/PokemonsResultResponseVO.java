package com.pokemon.api.integrator.entrypoint.rest.vo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PokemonsResultResponseVO {
    List<PokemonResponseVO> results;
}
