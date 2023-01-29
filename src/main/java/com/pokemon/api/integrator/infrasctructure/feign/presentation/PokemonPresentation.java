package com.pokemon.api.integrator.infrasctructure.feign.presentation;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
//entity se for salvar em banco
public class PokemonPresentation {
    String name;
    String url;
}
