package br.com.mundo.pokemons.pokemons.model.dto;

import lombok.Builder;

@Builder
public record PokemonDto(Long id,String name) {
}
